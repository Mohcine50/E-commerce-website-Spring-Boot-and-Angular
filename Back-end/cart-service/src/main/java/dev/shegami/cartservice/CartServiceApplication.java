package dev.shegami.cartservice;



import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import dev.shegami.cartservice.config.RsaKeysConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;


@SpringBootApplication
@AllArgsConstructor
@EnableConfigurationProperties(RsaKeysConfig.class)
@EnableFeignClients
public class CartServiceApplication {


	private RsaKeysConfig rsaKeysConfig;

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}




	@Bean
	public JwtDecoder JwtDecoder() {

		return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publicKey()).build();
	}

}
