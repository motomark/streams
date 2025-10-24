package com.motomark.streams.three;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;

public class TestCollectCollector extends TestPerson {

    private CollectCollector collectCollector;

    @Before
    public void init() {
        super.init();
        collectCollector = new CollectCollector();
    }

    @Test
    public void testOlderThan20() {
        List<Person> olderThan20Basic = collectCollector.getOlderThan20Basic(people);
        List<Person> olderThan20Collector = collectCollector.getOlderThan20UsingCollect(people);
        List<Person> olderThan20CollectorsToList = collectCollector.getOlderThan20UsingCollectorsToList(people);

        System.out.println("Basic:");
        olderThan20Basic.forEach(System.out::println);
        System.out.println("");
        System.out.println("Collector:");
        olderThan20Collector.forEach(System.out::println);
        System.out.println("");
        System.out.println("Collectors::toList");
        olderThan20CollectorsToList.forEach(System.out::println);

        assertArrayEquals(olderThan20Basic.toArray(), olderThan20Collector.toArray());
        assertArrayEquals(olderThan20Basic.toArray(), olderThan20CollectorsToList.toArray());

    }

    @Test
    public void testGroupByAge() {
        Map<Integer, List<Person>> map = collectCollector.groupPeopleByAge(people);
        printMap(map);
    }

    @Test
    public void testNameGroupByAge() {
        // See page. 55
        Map<Integer, List<String>> map = collectCollector.groupNameOfPeopleByAge(people);
        printMap(map);
    }

     @Test
    public void testGroupByFirstyCharAndReduceToMaxAge() {
        // See page. 55. Complicated.
        Map<Character, Optional<Person>> map = collectCollector.groupByFirstCharAndGetOldest(people);
        System.out.println("Oldest Person of each letter:");
        System.out.println(map);
    }

    private <T> void printMap(Map<Integer, List<T>> map) {
        // Based on p. 54 wanted to understand how I could iterate over the keys and the
        // values and pass an Atomic variable to keep count.
        final AtomicInteger counter = new AtomicInteger(0);
        map.entrySet().forEach(e -> {
            System.out.printf("Age %s: ", e.getKey());
            e.getValue().forEach(v -> {
                String prefix = "";
                if (e.getValue().size() > 1) {
                    prefix += counter.incrementAndGet();
                    prefix += ".";
                }
                // If we have a Person call getName otherwise implicit call toString().
                System.out.printf("%s%s ", prefix, (v instanceof Person ? ((Person) v).getName(): v));
            });
            counter.set(0);
            System.out.println();
        });
    }

    
}
