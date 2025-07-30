package com.zs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonReflection {
    public static void main(String[] args) throws Exception {

//        Person p = new Person("Mili", 19);
//        Class pc = p.getClass();
        // It manually loads a class
        Class pc = Class.forName("com.zs.Person");
        System.out.println(pc);

        Constructor[] cons = pc.getConstructors();
        System.out.println("-- List of constructors --");
        for (Constructor c : cons)
            System.out.println(c);

        Method[] ms = pc.getMethods();
        System.out.println("-- List of methods --");
        for (Method m : ms)
            System.out.println(m);

        Method[] decMs = pc.getDeclaredMethods();
        System.out.println("-- List of declared methods --");
        for (Method m : decMs)
            System.out.println(m);

        Field[] fs = pc.getDeclaredFields();
        System.out.println("-- List of fields --");
        for (Field f : fs)
            System.out.println(f);

    }
}
