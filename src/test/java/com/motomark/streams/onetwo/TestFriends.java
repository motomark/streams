package com.motomark.streams.onetwo;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.Predicate;

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

    @Test
    public void testFriendsStartWith() {
        assertEquals(2, 
            friends.filterBeginsWith(friendList, "H").size());
    }

     @Test
    public void testFriendsStartWithout() {
        assertEquals(4, 
            friends.filterBeginsWithout(friendList, "H").size());
    }

    @Test
    public void testFriendsPredicateStartWith() {
        // Create the prdicate lambda, then pass to the function for reuse. P29.
         Predicate<String> startsWith = name -> name.startsWith("H");
         assertEquals(2, friends
         .filterBeginsWithUsingPredicate(friendList, startsWith).size());
    }

     @Test
    public void testFriendsPredicateLexicalStartWith() {
        // Create the prdicate lambda, then pass to the function for reuse. P29.
         assertEquals(2, friends
         .filterBeginsWithUsingPredicateLexical(friendList, "H").size());
        assertEquals(1, friends
         .filterBeginsWithUsingPredicateLexical(friendList, "G").size());
        assertEquals(1, friends
         .filterBeginsWithUsingPredicateLexical(friendList, "W").size());
        assertEquals(0, friends
         .filterBeginsWithUsingPredicateLexical(friendList, "M").size());
        assertEquals(1, friends
         .filterBeginsWithUsingPredicateLexical(friendList, "W").size());
    }

}
