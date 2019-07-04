package be.businesstraining.domain;

public class GameResponse {


    private User user;
    private String generateNumber;

    public GameResponse() {
    }

    public GameResponse(User user, String generateNumber) {
        this.user = user;
        this.generateNumber = generateNumber;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGenerateNumber() {
        return generateNumber;
    }

    public void setGenerateNumber(String generateNumber) {
        this.generateNumber = generateNumber;
    }

}
