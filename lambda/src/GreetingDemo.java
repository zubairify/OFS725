public class GreetingDemo {

    private static interface Display {
        void print(String str);
        default void screen() {
            print("Display screen");
        }
    }

    public static void show(Object obj) {
        System.out.println(obj);
    }

    public void out(Object obj) {
        show(obj);
    }

    public static void main(String[] args) {
        Greeting g1 = () -> "Hello Lambda!";
        System.out.println(g1.sayHello());

        Greeting g2 = () -> {
            String msg = "Hola Amigo!";
            return msg;
        };
        System.out.println(g2.sayHello());

        Display d1 = (s) -> System.out.println(s);
        d1.print("Aloha Lambda");

        Display d2 = System.out::println; // (s) -> S.o.p(s);
        d2.print("Bonjour Lambda");

        Display d3 = GreetingDemo::show;    // (s) -> GreetingDemo.show(s);
        d3.print("Namaste Lambda");

        GreetingDemo demo = new GreetingDemo();
        Display d4 = demo::out;
        d4.print("Ciao Lambda");

        g1.greet();
        Greeting.welcome();

    }
}
