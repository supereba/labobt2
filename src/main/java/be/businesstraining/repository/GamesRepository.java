package be.businesstraining.repository;

import be.businesstraining.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface GamesRepository extends JpaRepository<Game, Long> {

    Set<Game> findAllByUser_Username(String username);
//    Set<Game> findAllByUser_UsernameAndProduit_Id(String username, Long idProduit);
//
//    Set<Game> findAllByProduit_Id(Long idProduit);

//    @Query(value =
//        "SELECT o FROM Game o " +
//                "WHERE o.produit = :produit " +
//                "AND o.montant = " +
//                "(SELECT MAX(e2.montant) FROM Game e2 WHERE e2.produit = :produit)")
//    // Pour cet exemple de JPQL avec Requetes imbriqués regardez ici, il
    // un exemple plus didactique simple : http://www.java2s.com/Tutorials/Java/JPA/4026__JPA_Query_Named_Parameter.htm
//    Game laMeilleureGamePourUnProduit(@Param("produit")Produit produit);
}
