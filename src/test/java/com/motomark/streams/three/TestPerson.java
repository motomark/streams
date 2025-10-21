package com.motomark.streams.three;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

// See Chapter 3.
public class TestPerson {

   protected List<Person> people;

    @Before
    public void init() {
        people = Arrays.asList
        (new Person("John", 20),
         new Person("Sara", 21), 
         new Person("Jane", 21), 
         new Person("Greg", 35));

    }

    @Test
    public void testAscendingAge() {

        // sorted() takes a Comparator.
        List<Person> sorted = people.stream()
            .sorted((person1, person2) -> person1.ageDifference(person2))
            .collect(Collectors.toList());

        printPeople("Ascending Order:", sorted);
        assertEquals(20, sorted.get(0).getAge());
        assertEquals(21, sorted.get(1).getAge());
        assertEquals(21, sorted.get(2).getAge());
        assertEquals(35, sorted.get(3).getAge());

        // the compile takes the first param as the target object and the second param as the method param. 
        // The compiler figures this out .. but we do need to take care. 
        List<Person> sorted2 = people.stream()
            .sorted(Person::ageDifference)
            .collect(Collectors.toList());

        printPeople("Ascending Order Concise:", sorted2);
        assertEquals(20, sorted2.get(0).getAge());
        assertEquals(21, sorted2.get(1).getAge());
        assertEquals(21, sorted2.get(2).getAge());
        assertEquals(35, sorted2.get(3).getAge());
    }

    @Test
    public void testDescendingAge() {
         // sorted() takes a Comparator.
        List<Person> sorted = people.stream()
            .sorted((person1, person2) -> person2.ageDifference(person1))
            .collect(Collectors.toList());

        printPeople("Descending Order:", sorted);
        assertEquals(35, sorted.get(0).getAge());
        assertEquals(21, sorted.get(1).getAge());
        assertEquals(21, sorted.get(2).getAge());
        assertEquals(20, sorted.get(3).getAge());

    }

    // Reusing a Comparator p.49
    @Test
    public void testComparatorReuseAge() {
        
        // Reusing a Comparator function. We can also reverse() the comparator.
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> ascending = people.stream()
            .sorted(compareAscending)
            .collect(Collectors.toList());
        
        List<Person> descending = people.stream()
            .sorted(compareDescending)
            .collect(Collectors.toList());

        printPeople("Ascending Age Order (Comparator Reuse):", ascending);
        printPeople("Descending Age Order (Comparator Reuse):", descending);
    
    }

    // Reusing the comparator for a persons name p.49. Since String has it's own comparator (compareTo()) we don't need to implementy one.
    @Test
    public void testComparatorReuseName() {
        
        // Reusing a Comparator function. We can also reverse() the comparator.
        Comparator<Person> compareAscending = (person1, person2) -> person1.getName().compareTo(person2.getName());
        Comparator<Person> compareDescending = compareAscending.reversed();

        List<Person> ascending = people.stream()
            .sorted(compareAscending)
            .collect(Collectors.toList());
        
        List<Person> descending = people.stream()
            .sorted(compareDescending)
            .collect(Collectors.toList());

        printPeople("Ascending Name Order (Comparator Reuse):", ascending);
        printPeople("Descending Name Order (Comparator Reuse):", descending);
    
    }


    // Instead of using sort on the stream we can use min or max and pass these the comparator. page 50. 
    @Test
    public void testMinAndMaxAge() {
        people.stream().min(Person::ageDifference).ifPresent(youngest -> System.out.println("Youngest: "+ youngest));
        people.stream().max(Person::ageDifference).ifPresent(oldest -> System.out.println("Oldest: "+ oldest));

        // Or with a reusable comparator:
        Comparator<Person> compare = (person1, person2) -> person1.ageDifference(person2);
        people.stream().min(compare).ifPresent(youngest -> System.out.println("Youngest: "+ youngest + " (resuable comparator)"));
        people.stream().max(compare).ifPresent(oldest -> System.out.println("Oldest: "+ oldest + " (resuable comparator)"));

    }

    protected void printPeople(String message, List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

}
