package com.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicrousuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrousuarioApplication.class, args);
	}

}
