package dev.shegami.productservice;

import dev.shegami.productservice.config.RsaKeysConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@AllArgsConstructor
@EnableConfigurationProperties(RsaKeysConfig.class)
@EnableFeignClients
public class ProductServiceApplication {

	private RsaKeysConfig rsaKeysConfig;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}


	@Bean
	public JwtDecoder JwtDecoder() {

		return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publicKey()).build();
	}
}
