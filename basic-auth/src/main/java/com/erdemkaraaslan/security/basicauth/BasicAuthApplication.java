package com.erdemkaraaslan.security.basicauth;

import com.erdemkaraaslan.security.basicauth.dto.CreateUserRequest;
import com.erdemkaraaslan.security.basicauth.model.Role;
import com.erdemkaraaslan.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createDummyData();
	}

	private void createDummyData() {
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Erdem")
				.username("erdem")
				.password("password123")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request);

		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("Görkem")
				.username("görkem")
				.password("password")
				.authorities(Set.of(Role.ROLE_USER))
				.build();
		userService.createUser(request2);


		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("No Name")
				.username("noname")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER, Role.ROLE_ADMIN))
				.build();
		userService.createUser(request3);
	}
}
