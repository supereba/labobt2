package be.businesstraining.repository;

import be.businesstraining.domain.Game;
import be.businesstraining.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface UsersRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
    Set<Game> findAllByUsername(String username);

    @Query(value = "From User c where c.amount = (select max(c.amount) from User c)")
    Set<User> clientAyantLeMeilleurSolde() ;

}
