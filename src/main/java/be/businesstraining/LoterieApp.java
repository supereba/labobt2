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


                System.out.println("Fin de l'initialisation par CommandLineRunner ...");
            } catch (Exception ex) {
              LOGGER.error("Exception rencontrée lors de l'initialisation par CommandLineRunner : "+ex);
            }
        };
	}


}
