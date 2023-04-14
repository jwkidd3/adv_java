package com.cisco.map;
import java.util.List;

public class Person {
    private Long id;
    private String name;
    private List<String> phoneNumbers;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Long id, String name, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}