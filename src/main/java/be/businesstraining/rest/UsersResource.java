package be.businesstraining.rest;


import be.businesstraining.domain.User;
import be.businesstraining.domain.Role;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.repository.RolesRepository;
import be.businesstraining.service.GamesService;
import com.sun.media.jfxmedia.events.PlayerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;

import be.businesstraining.domain.User;

@RestController
public class UsersResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersResource.class);

    private UsersRepository usersRepository;
    private RolesRepository roleRepository;
    private GamesService offresService;
    private GamesService gamesService;


    public UsersResource(UsersRepository usersRepository,
                         RolesRepository roleRepository,
                         GamesService offresService) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.offresService = offresService;

    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> register(@RequestBody User user) {
        // LOGGER.info(">>>>> RECU The username " + user.getUsername() + " - "+user.getPassword());
        try {
            User resultUser = usersRepository.findByUsername(user.getUsername());
            // Tester si le nom d'utilisatur est déjà réservé
            if (resultUser != null) {
                LOGGER.info("The username " + user.getUsername() + " is already taken !");
                return new ResponseEntity<String>("Username already taken: ", HttpStatus.CONFLICT);

            } else {
                // - Ajouter l'utilisateur à la BDD
                // Role role1 = new Role("USER", new HashSet<>(Arrays.asList(user)));
                Role role1 = roleRepository.findByRole("USER");   //new Role("USER", new HashSet<>(Arrays.asList(user)));
                LOGGER.info(">>>>>>>>   >>>> Role NULL ???: " + (role1 == null));
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//                user.setEnabled(true);
                user.setRoles(new HashSet<>(Arrays.asList(role1)));
                usersRepository.save(user);
                LOGGER.info("The username " + user.getUsername() + " has been added to the database !");

                return new ResponseEntity<String>("Success de l'enregistrement", HttpStatus.CREATED);

            }
        } catch (Exception ex) {
            LOGGER.error("Exception lors de l'enregistrement de l'utlisateur:" + ex);
            return new ResponseEntity<String>("Erreur lors de l'enregistrement : " + ex.getMessage(), HttpStatus.CONFLICT);
            // throw new Exception("Exception lors de l'enregistrement de l'utlisateur : "+ex.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(Principal user) {
        User player = usersRepository.findByUsername(user.getName());
        if (user != null) {
            return new ResponseEntity<User>(player, HttpStatus.OK);
            //return new ResponseEntity<String>(user,": Authenticated successfully", HttpStatus.OK);
        } else
            return new ResponseEntity<User>(player, HttpStatus.UNAUTHORIZED);
    }


//    @GetMapping("/update")
//    public ResponseEntity<?> update(Principal user) {
//
//
//    }


}
