package be.businesstraining.service;

import be.businesstraining.domain.Game;
import be.businesstraining.domain.User;
import be.businesstraining.repository.UsersRepository;
import be.businesstraining.repository.GamesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements  StatisticsService{
    private static final Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    private UsersRepository clientsRepository;
    private GamesRepository gamesRepository;

    public StatisticsServiceImpl(UsersRepository clientsRepository,
                                 GamesRepository gamesRepository ) {
        this.clientsRepository = clientsRepository;
        this.gamesRepository = gamesRepository;
    }

    @Override
    public User leClientAyantLeMeilleurSolde() {
        User user = clientsRepository.clientAyantLeMeilleurSolde().iterator().next();
       return  user;
    }
}
