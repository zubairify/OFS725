package com.zs;

import java.security.BasicPermission;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        // Calling another constructor on the same object - Chaining
        this("anonymous", -1);
    }

    private void print() {
        BasicPermission pm = new BasicPermission("Private method") {};
        System.out.println(this.name + " " + this.age);
    }

    @Override
    public String toString() {
        return "Name: " +  this.name + ", Age: " + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person p = (Person) obj;
            if(this.name.equals(p.name) && this.age == p.age)
                return true;
        }
        return false;
    }
}
