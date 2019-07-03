package be.businesstraining;

import be.businesstraining.domain.User;
import be.businesstraining.domain.Role;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.rest.UsersResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class LoterieApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersResource.class);

    public static void main(String[] args) {
        SpringApplication.run(LoterieApp.class, args);
    }
    @Bean
    BCryptPasswordEncoder encoder() {
        return 	new BCryptPasswordEncoder();
    }

	@Bean
    CommandLineRunner runIt(UsersRepository usersRepo) {
		return args -> {
            try {
//                User user1 = new User("user1", new BigDecimal("1000"), "User", "1", null, null, null, encoder().encode("password"), null);
//                Role role = new Role("USER", new HashSet<>(Arrays.asList(user1)));
//                user1.setRoles(new HashSet<>(Arrays.asList(role)));
//
//                User user2 = new User("user2", new BigDecimal("1000"), "User", "2", null, null, null, encoder().encode("password"), null);
////                Role role2 = new Role("ADMIN", new HashSet<>(Arrays.asList(user2)));
//                user2.setRoles(new HashSet<>(Arrays.asList(role)));
//
//                User user3 = new User("user3", new BigDecimal("1000"), "User", "3", null, null, null, encoder().encode("password"), null);
//                user3.setRoles(new HashSet<>(Arrays.asList(role)));
//
//                User user4 = new User("user4", new BigDecimal("1000"), "User", "4", null, null, null, encoder().encode("password"), null);
//                user4.setRoles(new HashSet<>(Arrays.asList(role)));
//
//                usersRepo.saveAll(Arrays.asList(user1, user2, user3, user4));

                System.out.println("Fin de l'initialisation par CommandLineRunner ...");
            } catch (Exception ex) {
              LOGGER.error("Exception rencontrée lors de l'initialisation par CommandLineRunner : "+ex);
            }
        };
	}


}
