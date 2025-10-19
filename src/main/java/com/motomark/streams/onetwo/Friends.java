package com.motomark.streams.onetwo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Friends {

    public void basicStreamIteration(List<String> friends) {
        friends.forEach(name -> System.out.println(name));
    }

    public void basicStreamIteration2(List<String> friends) {
        friends.forEach(System.out::println);
    }

    public void toUppercase(List<String> friends) {
        basicStreamIteration2(friends.stream().map(friend -> friend.toUpperCase()).toList());
    }

    public void toUppercaseSorted(List<String> friends) {
        friends.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
    }

    // Transform the input into a count for each. This returns a collection of count numbers for each item in the input collection.
    public void transformToCount(List<String> friends) {
        friends.stream().map(friend -> friend.length()).forEach(count -> System.out.print(count + " "));;
    }

    public List<String> filterBeginsWith(List<String> friends, String beginsWith) {
        return friends.stream()
            .filter(friend -> friend.startsWith(beginsWith))
            .collect(Collectors.toList());
    }

     public List<String> filterBeginsWithout(List<String> friends, String beginsWith) {
        return friends.stream()
            .filter(friend -> !friend.startsWith(beginsWith))
            .collect(Collectors.toList());
    }

    public List<?> filterBeginsWithUsingPredicate(List<String> friends, final Predicate<String> filterPredicate) {
        // pages 28, 29. Pass the Predicate so we can re-use.
        return friends.stream().filter(filterPredicate).toList();
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public List<?> filterBeginsWithUsingPredicateLexical(List<String> friends, String letter) {
        // page 30. Pass the Predicate with Lexical scoping so we can re-use.
        return friends.stream().filter(checkIfStartsWith(letter)).toList();
    }


}
