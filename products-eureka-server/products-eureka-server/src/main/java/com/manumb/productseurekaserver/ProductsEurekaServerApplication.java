package com.manumb.productseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer		//para habilitar la clase como servidor de eureka
public class ProductsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsEurekaServerApplication.class, args);
	}

}
