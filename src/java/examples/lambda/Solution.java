package examples.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("Vasya", "vasya1rde@mail.ru", "vasyaPass"));
        users.add(new User("Petya", "Petya1rde@mail.ru", "PetyaPass"));
        users.add(new User("Tetya", "Tetya1rde@mail.ru", "TetyaPass"));
        users.add(new User("Igor", "Igor1rde@mail.ru", "IgorPass"));
        users.add(new User("Victor", "Victor1rde@mail.ru", "VictorPass"));
        users.add(new User("Anastasia", "Anastasia1rde@mail.ru", "AnastasiaPass"));
    }

    public static void main(String[] args) {
        System.out.println(users.stream().map(user -> user.getName()).collect(Collectors.joining(", ")));
        users.stream().map(user -> user.getAuth()).forEach(arr -> System.out.printf("Login: %s  \t| password: %s%n", arr.get(0), arr.get(1)));

        System.out.println(users.stream().map(User::getName).min(Comparator.comparingInt(String::length)).get());

    }
}
