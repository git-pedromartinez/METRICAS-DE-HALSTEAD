package models;

public class TokenDTO {
    public String token;
    public int counter;

    public TokenDTO(String token, int counter) {
        this.token = token;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "token='" + token + '\'' +
                ", counter=" + counter +
                '}';
    }
}
