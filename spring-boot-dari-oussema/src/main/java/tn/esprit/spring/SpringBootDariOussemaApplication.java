package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootDariOussemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDariOussemaApplication.class, args);
	}

}
