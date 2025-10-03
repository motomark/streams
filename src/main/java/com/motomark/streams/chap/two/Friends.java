package com.motomark.streams.chap.two;

import java.util.List;

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


}
