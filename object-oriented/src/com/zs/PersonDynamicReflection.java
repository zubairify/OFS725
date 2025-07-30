package com.zs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonDynamicReflection {

    public static void main(String[] args) throws Exception {

        Class pc = Class.forName("com.zs.Person");

        Constructor c = pc.getConstructor(null);
        Object obj = c.newInstance(null);
        System.out.println(obj);

        Constructor c2 = pc.getConstructor(String.class, int.class);
        Object obj2 = c2.newInstance("Frank", 23);
        System.out.println(obj2);

        Method mp = pc.getDeclaredMethod("print", null);
        mp.setAccessible(true);
        mp.invoke(obj2, null);
    }
}
