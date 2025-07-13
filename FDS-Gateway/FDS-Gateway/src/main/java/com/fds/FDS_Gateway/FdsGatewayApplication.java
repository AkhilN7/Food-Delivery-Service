package com.fds.FDS_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FdsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FdsGatewayApplication.class, args);
	}

}
