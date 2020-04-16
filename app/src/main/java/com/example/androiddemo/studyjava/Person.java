package com.example.androiddemo.studyjava;

public class Person implements Cloneable {

    // 实现 Cloneable 接口
    String name;    // 学生名字
    int age;    // 学生年龄
    public Person(String name,int age) {
        // 构造方法
        this.name = name;
        this.age = age;
    }
    public Person() {
        this.name = "";
        this.age = 0;
    }
    public String toString() {
        return"学生名字："+name+"，年龄："+age+"学号：";
    }

}

class Student extends Person {

    private int no;    //
    public Student(String name, int age) {
        super(name, age);

    }

    @Override
    public String toString() {
        String a = super.toString();
        return"学生名字："+name+"，年龄："+age+"学号："+no;
    }
}