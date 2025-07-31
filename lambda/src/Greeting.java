
@FunctionalInterface
public interface Greeting {
    String sayHello();

    default void greet() {
        System.out.println("Happy holidays");
        temp();
    }

    static void welcome() {
        System.out.println("Welcome to Lambda");
    }

    private void temp() {
        System.out.println("Goodbye!");
    }
}

