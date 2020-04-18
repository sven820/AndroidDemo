package com.example.androiddemo.jsonxuliehua;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jsonxuliehua {

    Jsonxuliehua() {

        Person[] testarr = new Person[10];
        ArrayList<Person> family = new ArrayList<Person>();
        Person pp = new Person();
        pp.name = "mm";
        pp.age = 20;
        family.add(pp);
        testarr[0] = pp;

        Map p = new HashMap();
        p.put("name", "jxf");
        p.put("age", 18);
        p.put("family", family);

    }
}

class Person implements Serializable {

    String name;
    int age;
    Person[] family;
}
