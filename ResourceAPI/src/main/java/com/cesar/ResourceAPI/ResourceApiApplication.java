package com.cesar.ResourceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ResourceApiApplication {

	@GetMapping("/resource")
	public String getResource(@AuthenticationPrincipal Jwt jwt){
		return "This works! " + jwt.getClaimAsString("user_name");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApiApplication.class, args);
	}

}