package com.motomark.streams.three;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * See Chapter 3, page 52/55.
 */
public class CollectCollector {

    // Simpler way but risks mutating.
    public List<Person> getOlderThan20Basic(List<Person> people) {
        List<Person> olderThan20 = new ArrayList<>();
        people.stream().filter(person -> person.getAge() > 20).forEach(person -> olderThan20.add(person));
        return olderThan20;
    }

    // Handle immutable list so hguaranteed thread safety.
    public List<Person> getOlderThan20UsingCollect(List<Person> people) {
        return people.stream().filter(person -> person.getAge() > 20).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // More concise way. 
    public List<Person> getOlderThan20UsingCollectorsToList(List<Person> people) {
        return people.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
    }
    
    // p54. Various ways to group by age. Used a getAge Function. GroupingsBy returns a Map. See test.
    public Map<Integer, List<Person>> groupPeopleByAge(List<Person> people) {
        final Function<Person, Integer> byAge = person -> person.getAge();
        //return people.stream().collect(Collectors.groupingBy(Person::getAge));
        return people.stream().collect(Collectors.groupingBy(byAge));
    }

    public Map<Integer, List<String>> groupNameOfPeopleByAge(List<Person> people) {
        return people.stream().collect(groupingBy(Person::getAge, mapping(Person::getName, toList())));
    }

    // p55. Group names on first leter of name and reduce to the person with max age.
    public Map<Character, Optional<Person>> groupByFirstCharAndGetOldest(List<Person> people) {
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        return people.stream()
            .collect(groupingBy(person -> person.getName().charAt(0), 
                reducing(BinaryOperator.maxBy(byAge))));    
    }


}
