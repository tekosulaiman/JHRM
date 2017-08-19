package jcodev.jbpm.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = "jcodev.jbpm.api")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
