package com.motomark.streams.onetwo;

import java.util.List;

public class ReduceFriends {

    // Page 37. Maps on to a Stream of int, then reduce operates on the stream calling reduce.
    public int totalCharsInAllNamesUsingReduce(List<String> friends) {
        return friends.stream().map(friend -> friend.length()).reduce(0, (a,b) -> a+b);
    }

    // Page 36. More convenient mapToInt to map to an IntStream. Then calls sum over the IntStream.
    public int totalCharsInAllNamesUsingMapToInt(List<String> friends) {
        return friends.stream().mapToInt(friend -> friend.length()).sum();
    }

}
