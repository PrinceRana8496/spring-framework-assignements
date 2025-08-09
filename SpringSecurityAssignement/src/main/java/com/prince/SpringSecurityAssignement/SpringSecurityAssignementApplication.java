package com.prince.SpringSecurityAssignement;

import com.prince.SpringSecurityAssignement.entity.Role;
import com.prince.SpringSecurityAssignement.entity.User;
import com.prince.SpringSecurityAssignement.repository.RoleRepository;
import com.prince.SpringSecurityAssignement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityAssignementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAssignementApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder encoder) {
		return args -> {
			Role adminRole = roleRepo.save(new Role( "ROLE_ADMIN"));
			Role userRole = roleRepo.save(new Role("ROLE_USER"));

			userRepo.save(new User("admin", encoder.encode("admin123"), Set.of(adminRole)));
			userRepo.save(new User("user", encoder.encode("user123"), Set.of(userRole)));
		};
	}

}
