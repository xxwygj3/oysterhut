package com.memuli.oysterhutweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication
public class OysterhutWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OysterhutWebApplication.class, args);
	}
}
