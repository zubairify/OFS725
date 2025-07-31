package com.zs;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello from Normal class!");
    }
}

public class GreetingDemo {
    class InnerGreetingImpl implements Greeting {
        @Override
        public void sayHello() {
            System.out.println("Hello from Inner class!");
        }
    }

    private static class StaticInnerGreetingImpl implements Greeting {
        @Override
        public void sayHello() {
            System.out.println("Hello from Static Inner class!");
        }
    }

    public void anotherGreeting() {
        class NestedGreetingImpl implements Greeting {
            @Override
            public void sayHello() {
                System.out.println("Hello from Nested class!");
            }
        };
        new NestedGreetingImpl().sayHello();
    }

    public void oneMoreGreeting() {
        Greeting g = new Greeting () {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous class!");
            }
        };
        g.sayHello();
    }

    public void oneLastGreeting() {
        Greeting g = () -> System.out.println("Hello from Lambda!");
        g.sayHello();
    }

    public static void main(String[] args) {
        Greeting g1 = new GreetingImpl();
        g1.sayHello();

        GreetingDemo demo = new GreetingDemo();
        Greeting g2 = demo.new InnerGreetingImpl();
        g2.sayHello();

        Greeting g3 = new GreetingDemo.StaticInnerGreetingImpl();
        g3.sayHello();

        demo.anotherGreeting();
        demo.oneMoreGreeting();
        demo.oneLastGreeting();
    }
}
