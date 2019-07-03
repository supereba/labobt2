package be.businesstraining.rest;

import be.businesstraining.domain.Game;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.service.GamesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/games")
public class GamesResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamesResource.class);

    private UsersRepository usersRepository;
    private GamesService gamesService;

    public GamesResource(UsersRepository usersRepository,
                         GamesService gamesService) {
        this.usersRepository = usersRepository;
        this.gamesService = gamesService;

    }

//    @PostMapping("/{idProduit}/{montantGame}")
//    public ResponseEntity<?> donnerOffre(@PathVariable Long idProduit,
//                                   @PathVariable BigDecimal montantGame,
//                                   Principal user) {
//        try {
//            // Récupérer le client à partir du contexte de sécurité (via le raccourci principal) et lui ajouter l'Game
//            String username = user.getName();
//            gamesService.deposerGame(username, idProduit, montantGame);
//            LOGGER.info("Succes du dépôt de l'offre");
//            return new ResponseEntity<String>("Success du dépôt", HttpStatus.OK);
//
//        } catch (Exception ex) {
//            LOGGER.error("Exception lors du dépôt de l'Offre: " + ex);
//            return new ResponseEntity<String>("Erreur lors de l'ajout de l'Offre : " + ex.getMessage(), HttpStatus.CONFLICT);
//        }
//    }

    @GetMapping("/me")
    public ResponseEntity<?> toutesMesOffres(Principal user) {
        try {
            // Récupérer le client à partir du contexte de sécurité (via le raccourci principal) et lui ajouter l'offre
            String me = user.getName();
            Set<Game> games =gamesService.tousLesJeuxParUtilisateur(me);
            return (games == null)?
                    new ResponseEntity<>(HttpStatus.NOT_FOUND):
                    new ResponseEntity<Set<Game>>(games, HttpStatus.OK);

        } catch (Exception ex) {
            LOGGER.error("Exception lors de la consultation de mes offres: " + ex);
            return new ResponseEntity<String>("Erreur lors de l'ajout de l'Offre : " + ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

//    @GetMapping("/me/{idProduit}")
//    public ResponseEntity<?> toutesMesGamesPourUnProduit(@PathVariable Long idProduit, Principal user) {
//        try {
//            // Récupérer le client à partir du contexte de sécurité (via le raccourci principal) et lui ajouter l'game
//            String me = user.getName();
//            Set<Game> games =gamesService.toutesLesGamesParUtilisateurParProduit(me,idProduit);
//            return (games == null)?
//                    new ResponseEntity<>(HttpStatus.NOT_FOUND):
//                    new ResponseEntity<Set<Game>>(games, HttpStatus.OK);
//
//        } catch (Exception ex) {
//            LOGGER.error("Exception lors de la consultation de mes games: " + ex);
//            return new ResponseEntity<String>("Erreur lors de l'ajout de l'game : " + ex.getMessage(), HttpStatus.CONFLICT);
//        }
//    }

}
