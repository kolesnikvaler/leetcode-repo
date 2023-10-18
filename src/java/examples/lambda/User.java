package examples.lambda;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    private String name;
    private String login;
    private String password;

    private List<String> auth;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;

        auth = new ArrayList<>();
        auth.add(login);
        auth.add(password);
    }
}
