package sopt.org.fourthSeminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableFeignClients
public class FourthSeminarApplication {
	public static void main(String[] args) {
		SpringApplication.run(FourthSeminarApplication.class, args);
	}
}
