package examples.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        var stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");

        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));
        System.out.println();
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");
        System.out.println(String.join(", ", list));
        System.out.println(list.stream().filter(e -> e.split("=").length == 2).collect(Collectors.joining(", ")));


    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {
        return stringStream.collect(Collectors.toMap(e -> e, String::length));
    }
}
