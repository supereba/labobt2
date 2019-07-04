package be.businesstraining.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private User user;

    private LocalDateTime dateCreation;

    private int result;
    public Game() {
    }

    // Rajouté pour les besoins de l'application de loterie
    private int bet;//mise
    private int gain;


    public int getBet() {
        return bet;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Game(User user, int result, LocalDateTime dateCreation,int bet,int gain) {
        this.user = user;
        this.dateCreation = dateCreation;
        this.bet=bet;
        this.gain=gain;
        this.result=result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   }
