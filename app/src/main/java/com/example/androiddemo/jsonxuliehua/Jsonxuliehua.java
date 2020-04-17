package com.example.androiddemo.jsonxuliehua;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jsonxuliehua {

    Jsonxuliehua() {

        Person[] family = new ArrayList<Person>();

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
