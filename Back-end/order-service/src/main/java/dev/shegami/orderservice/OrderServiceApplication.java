package dev.shegami.orderservice;

import dev.shegami.orderservice.config.RsaKeysConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@SpringBootApplication
@AllArgsConstructor
@EnableConfigurationProperties(RsaKeysConfig.class)
@EnableFeignClients
public class OrderServiceApplication {

	private RsaKeysConfig rsaKeysConfig;
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	@Bean
	public JwtDecoder JwtDecoder() {

		return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publicKey()).build();
	}
}
