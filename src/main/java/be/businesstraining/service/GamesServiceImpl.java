package be.businesstraining.service;

import be.businesstraining.domain.Game;
import be.businesstraining.domain.User;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.repository.GamesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class GamesServiceImpl implements GamesService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GamesServiceImpl.class);

    private UsersRepository clientsRepository;
    private GamesRepository offresRepository;

    public GamesServiceImpl(UsersRepository clientsRepository,
                            GamesRepository offresRepository ) {
        this.clientsRepository = clientsRepository;
        this.offresRepository = offresRepository;
    }

//    @Override
//    public void deposerOffre(String username, Long idProduit,
//                             @PathVariable BigDecimal montantOffre) {
//        try {
//            // Récupérer le Cient offrant
//            User client = clientsRepository.findByUsername(username);
//
//            // Récupérer le produit objet de l'offre
//            Produit produit = produitsRepository.findById(idProduit).orElse(null);
//
//            // Vérifier que le montant de l'offre est inférieur au solde du client            //
//            // et que l'offre est supérieure au prix minimum demandé le produit
////            if ((client.getSolde().compareTo(montantOffre)<0)||
////                (montantOffre.compareTo(produit.getPrixMinimumDemande())<0)) {
////                LOGGER.info("Il y a une incohérence au niveau de la valeur de l'offre");
////                throw new Exception("Incohérence au niveau de la valeur de l'offre");
////            }
//
//            // Crére l'objet de la nouvelle Offre
//            Offre offre = new Offre(client, produit, montantOffre, LocalDateTime.now());
//
//            // Ajouter la nouvelle offre à la liste des offres du client
//            Set<Offre> offresDuClient = client.getOffres();
//            offresDuClient.add(offre);
//            client.setOffres(offresDuClient);
//            LOGGER.info("Ajout de l'offre à la liste des offres du client");
//
//            // Ajouter la nouvelle offre à la liste des offres relatives à un produit
//
//            Set<Offre> offresDuProduit = produit.getOffres();
//            offresDuProduit.add(offre);
//            produit.setOffres(offresDuProduit);
//            LOGGER.info("Ajout de l'offre à la liste des offres relative au produit");
//            // Actualiser le solde du client en lui ôtant le montant de l'offre
//            //client.setSolde(client.getSolde().subtract(montantOffre));
//            // Synchroniser les objets persistants
//            offresRepository.save(offre);
//
//        } catch (Exception ex) {
//            LOGGER.error("Exception lors du dépôt de l'Offre: " + ex.getMessage());
//        }
//    }

    @Override
    public Set<Game> tousLesJeuxParUtilisateur(String username) {
        Set<Game> a_retourner = new HashSet<>();
        try {
            a_retourner = offresRepository.findAllByUser_Username(username);
            LOGGER.info("********* Le nombre d offres de : " + username + " est : "+ a_retourner.size() );
        }catch (Exception ex){
            LOGGER.error("******** Exception lors de la consultation de mes offres: " + ex.getMessage());
        }
        return  a_retourner;
    }

}
