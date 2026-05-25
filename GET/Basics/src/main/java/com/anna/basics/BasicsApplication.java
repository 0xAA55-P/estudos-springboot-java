package com.anna.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Diz que essa classe deve ser usada como base para toda nossa aplicacao
 *
 * Mesma coisa de:
 *
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class BasicsApplication {

	public static void main(String[] args) {
	  /**
     * Roda a aplicação
	   */
		SpringApplication.run(BasicsApplication.class, args);
	}

}
