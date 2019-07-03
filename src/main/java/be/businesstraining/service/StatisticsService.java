package be.businesstraining.service;

import be.businesstraining.domain.Game;
import be.businesstraining.domain.User;

public interface StatisticsService {

    // La meilleure offre pour un produit
//    Game laMeilleureOffrePourUnProduit(Long idProduit);

    // Le client ayant le solde le plus élevé
    User leClientAyantLeMeilleurSolde();

    // Le nombre d'offres pour un produit
    // Le client ayant déposé le plus d'offres tous produits confondus
    // Le client ayant déponsé la meilleure offre pour un produit
    // Les nouvelles offres (qui ont été déposée dans les derniers 24 heures)

}
