package dev.shegami.productservice.config;

import com.nimbusds.jose.shaded.gson.JsonObject;
import dev.shegami.productservice.models.AppUser;
import dev.shegami.productservice.services.AccountClientService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.time.Instant;
import static dev.shegami.productservice.Utils.RequestManagement.resolveToken;
import static dev.shegami.productservice.Utils.RequestManagement.writeResponse;


@AllArgsConstructor
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtDecoder jwtDecoder;
    private final AccountClientService accountClientService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String jwtToken;
        boolean tokenExpired;
        Instant issuerAt, expiredAt;
        String requestedURI;
        JsonObject jsonObject = new JsonObject();

        requestedURI = request.getRequestURI();

        if (requestedURI.contains("/v3/api-docs") || requestedURI.contains("/swagger-ui/")) {

            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = resolveToken(request);


        if (jwtToken == null) {
            jsonObject.addProperty("Message", "NO TOKEN PROVIDED");
            writeResponse(response, HttpServletResponse.SC_UNAUTHORIZED, jsonObject);
            return;
        }

        try {
            Jwt jwt = jwtDecoder.decode(jwtToken);

            AppUser userDetails = accountClientService.loadUserByUsername(jwt.getSubject());

            if (userDetails == null) {
                jsonObject.addProperty("Message", "NO USER WITH THIS USERNAME");
                writeResponse(response, HttpServletResponse.SC_UNAUTHORIZED, jsonObject);
                return;
            }


            issuerAt = jwt.getIssuedAt();
            expiredAt = jwt.getExpiresAt();

            tokenExpired = issuerAt.isBefore(expiredAt);

            if (!tokenExpired) {
                jsonObject.addProperty("Message", "Token expired");
                writeResponse(response, HttpServletResponse.SC_FORBIDDEN, jsonObject);
                return;
            }
            filterChain.doFilter(request, response);

        } catch (JwtException exception) {
            jsonObject.addProperty("Message", "INVALID TOKEN");
            writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, jsonObject);
        }

    }


}


