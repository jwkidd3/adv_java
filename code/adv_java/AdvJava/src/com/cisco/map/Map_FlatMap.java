package com.cisco.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map_FlatMap {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1L,"hediyeh",Arrays.asList("12","34"))
                ,new Person(2L,"sara",Arrays.asList("56"))
                ,new Person(3L,"shabnam",Arrays.asList("78","9","10,11"))
                ,new Person(4L,"shiva",Arrays.asList())
        );


        //names
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        names.stream().forEach(System.out::println);

        //phones
        List<List<String>> phones = people.stream()
                .map(Person::getPhoneNumbers)
                .collect(Collectors.toList());
        System.out.println(phones);

      //flat_map
        List<String> phonesFlatMap = people.stream()
                .flatMap(person -> person.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phonesFlatMap);


    }
}