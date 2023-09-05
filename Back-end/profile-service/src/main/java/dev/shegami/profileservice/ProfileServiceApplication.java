package dev.shegami.profileservice;

import dev.shegami.profileservice.config.RsaKeysConfig;
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
public class ProfileServiceApplication {

	private RsaKeysConfig rsaKeysConfig;
	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}
	@Bean
	public JwtDecoder JwtDecoder() {

		return NimbusJwtDecoder.withPublicKey(rsaKeysConfig.publicKey()).build();
	}
}
