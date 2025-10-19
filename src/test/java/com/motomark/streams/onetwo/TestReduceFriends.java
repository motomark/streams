package com.motomark.streams.onetwo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestReduceFriends {

    List<String> friendList;
    ReduceFriends friends;
    @Before
    public void init() {
        friends = new ReduceFriends();
        friendList = List.of("Hayley", "Helen", "Rob", "Gordon", "Will", "Barry");
    }

    @Test
    public void testTotalCharsInAllNames() {
        assertEquals(29, friends.totalCharsInAllNamesUsingMapToInt(friendList));
        assertEquals(29, friends.totalCharsInAllNamesUsingReduce(friendList));
    }

}
