package com.motomark.streams.onetwo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceFriends {

    // Page 37. Maps on to a Stream of int, then reduce operates on the stream calling reduce.
    public int totalCharsInAllNamesUsingReduce(List<String> friends) {
        return friends.stream().map(friend -> friend.length()).reduce(0, (a,b) -> a+b);
    }

    // Page 36. More convenient mapToInt to map to an IntStream. Then calls sum over the IntStream.
    public int totalCharsInAllNamesUsingMapToInt(List<String> friends) {
        return friends.stream().mapToInt(friend -> friend.length()).sum();
    }

    public Optional<String> findLongestNameUsingReduce(List<String> friends) {
        return friends.stream().reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
    }

    // Page 39. joining is a Collector. A collector is a sink object, in this case a String Joiner.
    public String joinFriends(List<String> friends) {
        return friends.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
    }

}
