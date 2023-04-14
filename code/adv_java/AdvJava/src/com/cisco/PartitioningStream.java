package com.cisco;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cisco.PartitioningStream.Gender;

public class PartitioningStream {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("hediyeh", Gender.Female),
                new Person("soheil", Gender.Male),
                new Person("shabnam", Gender.Female),
                new Person("ali", Gender.Male),
                new Person("shiva", Gender.Female)
        );

        Map<Boolean,String> booleanStringMap = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getGender() == Gender.Male
                        ,Collectors.mapping(Person::getName,Collectors.joining(","))));
        System.out.println("------Boolean String Map Stream----------"+booleanStringMap);

        Map<Boolean,List<Person>> booleanListMap = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getGender() == Gender.Female
                        ,Collectors.toList()));
        System.out.println("------Boolean Map Stream----------"+booleanListMap);

    }

    public static class Person{
        private String name;
        private Gender gender;

        public Person() {
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    public enum Gender{
        Male,Female
    }
}