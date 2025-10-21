package com.motomark.streams.three;

import java.util.function.Function;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class TestMultipleFluent extends TestPerson {

    // See page 51.
    @Test
    public void testSortInAscendingByAgeName() {

        // See Appendix 1. p156. Lambda Expressions / Functions.
        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byName = person -> person.getName();

        // This shows us what the Functions do. When input Person it returns the age etc.
        System.out.println(people.get(0));
        System.out.println(byAge.apply(people.get(0)));
        System.out.println(byName.apply(people.get(0)));
        
        // the sorted() method accepts a comparator using comparing. 
        // In this case we pass the Function/s to represent the Comparator.
        // The apply method is invoked by comparing.
        printPeople("Sort ascending by age and name", 
            people.stream()
                .sorted(comparing(byAge).thenComparing(byName)).collect(toList()));
    }

}
