package com.example.androiddemo.store;

import org.litepal.crud.DataSupport;

public class Person extends DataSupport {

    String name;
    int age;
//    Person[] family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Person[] getFamily() {
//        return family;
//    }
//
//    public void setFamily(Person[] family) {
//        this.family = family;
//    }
}
