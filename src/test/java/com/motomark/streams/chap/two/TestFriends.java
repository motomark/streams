package com.motomark.streams.chap.two;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestFriends {

    List<String> friendList;
    Friends friends;
    @Before
    public void init() {
        friends = new Friends();
        friendList = List.of("Hayley", "Helen", "Rob", "Gordon", "Will", "Barry");
    }

    @Test
    public void testBasic() {
        friends.basicStreamIteration(friendList);
    }


    @Test
    public void testBasic2() {
        friends.basicStreamIteration2(friendList);
    }

    @Test
    public void testToUppercase() {
        friends.toUppercase(friendList);
    }

    @Test
    public void testToUppercaseSorted() {
        friends.toUppercaseSorted(friendList);
    }

    @Test
    public void testTransformToCount() {
        friends.transformToCount(friendList);
    }

    

}
