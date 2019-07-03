package be.businesstraining.rest;

import be.businesstraining.domain.User;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.service.GamesService;
import be.businesstraining.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/stats")
public class StatisticsResource {


    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsResource.class);

    private UsersRepository usersRepository;
    private GamesService gamesService;
    private StatisticsService statisticsService;

    public StatisticsResource(UsersRepository clientsRepository,
                              GamesService gamesService,
                              StatisticsService statisticsService) {
        this.usersRepository = clientsRepository;
        this.gamesService = gamesService;
        this.statisticsService =statisticsService;
    }

//   // Toutes les offres pour un produit
//    @GetMapping("/offres/{idProduit}")
//    public ResponseEntity<?> toutesLesOffresPourUnProduit(@PathVariable Long idProduit){
//            try {
//                Set<Offre> offres = produitsService.toutesLesOffresParProduit(idProduit);
//                return (offres == null)?
//                        new ResponseEntity<>(HttpStatus.NOT_FOUND):
//                        new ResponseEntity<Set<Offre>>(offres, HttpStatus.OK);
//
//            } catch (Exception ex) {
//                LOGGER.error("Exception lors de la consultation de mes offres: " + ex);
//                return new ResponseEntity<String>("Erreur lors de l'obtension de toutes les offres d un produit : " + ex.getMessage(), HttpStatus.CONFLICT);
//            }
//    }
//        // La meilleure offre pour un produit
//        @GetMapping("/offres/{idProduit}/best")
//        public ResponseEntity<?> laMeilleureOffrePourUnProduit(@PathVariable Long idProduit){
//            try {
//                Offre offre = statisticsService.laMeilleureOffrePourUnProduit(idProduit);
//
//                return (offre == null)?
//                        new ResponseEntity<>(HttpStatus.NOT_FOUND):
//                        new ResponseEntity<Offre>(offre, HttpStatus.OK);
//
//            } catch (Exception ex) {
//                LOGGER.error("Exception lors de l'obtention de la meilleure offre du produit: " + ex);
//                return new ResponseEntity<String>("Erreur lors de l'obtention de la meilleure offre du produit : " + ex.getMessage(), HttpStatus.CONFLICT);
//            }
//        }
//
//    // Le client ayant déposé la meilleure offre pour un produit
//    @GetMapping("/offres/{idProduit}/gagant")
//    public ResponseEntity<?> leClientQuiADeposeLaMeilleureOffrePourUnProduit(@PathVariable Long idProduit){
//        try {
//            Offre offre = statisticsService.laMeilleureOffrePourUnProduit(idProduit);
//            if (offre == null)
//                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            else {
//                User client = offre.getUser();
//                return  new ResponseEntity<User>(client, HttpStatus.OK);
//            }
//
//        } catch (Exception ex) {
//            LOGGER.error("Exception lors de l'obtention du client qui a fait la meilleure offre du produit: " + ex);
//            return new ResponseEntity<String>("Erreur lors de l'obtention du client qui a fait la meilleure offre du produit : " + ex.getMessage(), HttpStatus.CONFLICT);
//        }
//    }
//
//    // Le nombre d'offres pour un produit
//    @GetMapping("/offres/{idProduit}/count")
//    public ResponseEntity<?> leNombreDOffresPourUnProduit(@PathVariable Long idProduit){
//        try {
//            Set<Offre> offres = produitsService.toutesLesOffresParProduit(idProduit);
//            return new ResponseEntity<Integer>(offres.size(), HttpStatus.OK);
//
//        } catch (Exception ex) {
//            LOGGER.error("Exception lors de la déterminisation du nombre d'offres: " + ex);
//            return new ResponseEntity<String>("Erreur lors de la déterminisation du nombre d'offres pour un produit: " + ex.getMessage(), HttpStatus.CONFLICT);
//        }
//    }

    // Le client ayant le solde le plus élevé
    @GetMapping("/clients/best")
    public ResponseEntity<?> leClientAyantLeMeilleurSolde(){
        try {
            User user = statisticsService.leClientAyantLeMeilleurSolde();

            return (user == null)?
                    new ResponseEntity<>(HttpStatus.NOT_FOUND):
                    new ResponseEntity<User>(user, HttpStatus.OK);

        } catch (Exception ex) {
            LOGGER.error("Exception lors de la détermination du meilleur client: " + ex);
            return new ResponseEntity<String>("Erreur lors de la détermination du meilleur client: " + ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // Les nouvelles offres (qui ont été déposée dans les derniers 24 heures)


}
