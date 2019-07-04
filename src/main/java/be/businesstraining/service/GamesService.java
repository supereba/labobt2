package be.businesstraining.service;

import be.businesstraining.domain.Game;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Set;

public interface GamesService {

    Set<Game> tousLesJeuxParUtilisateur (String username);
    String generate(int min, int max);
    void saveData(String username);


}
