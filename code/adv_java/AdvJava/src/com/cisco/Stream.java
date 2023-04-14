package com.cisco;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Stream {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("hediyeh", 29, Gender.Female),
                new Person("ali", 32, Gender.Male),
                new Person("zahra", 18, Gender.Female)
        );

        //Imperative Approach
        for (Person person : people) {
            if (person.getGender() == Gender.Male) {
                System.out.println(person.toString());
            }
        }

        //Declarative Approach
        people.stream()
                .filter(person -> person.getGender().equals(Gender.Male))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //allMath
        System.out.println(people.stream()
                .allMatch(person -> person.getAge() < 15)
        );

        //anyMatch
        System.out.println(people.stream()
                .anyMatch(person -> person.getAge() > 65)
        );
    }

    static class Person {
        private final String name;
        private final int age;
        private final Gender gender;

        public Person(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        Male, Female
    }
}
