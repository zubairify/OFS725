import java.util.function.*;

public class LambdaDemo {
	
	public static void print(Object obj) {
		System.out.println(obj);
	}
	public static void print(Object first, Object second) {
		System.out.println(first + " " + second);
	}

	public static void main(String[] args) {
		
		Consumer<String> c = (s) -> System.out.println(s);
		c.accept("Adios");
		
		Consumer<String> c1 = System.out::println;
		c1.accept("Hello");
		c1.accept("Hola");
		c1.accept("Bonjour");
		
		Consumer<String> c2 = LambdaDemo::print;
		c2.accept("Aloha");

		BiConsumer<String, Integer> p1 = LambdaDemo::print;
		p1.accept("Polo", 21);

		Supplier<String> s1 = () -> "Zubair";
		System.out.println(s1.get());
		print(s1.get());
		
		Supplier<Double> random = () -> Math.random();
		System.out.println(random.get());
		
		Predicate<Integer> nonNegative = (x) -> x >= 0;
		System.out.println(nonNegative.test(3));
		System.out.println(nonNegative.test(-2));
		
		Predicate<Integer> isEven = (x) -> x % 2 == 0;
		System.out.println(isEven.test(5));
		
		BiPredicate<String, String> contains =
				(str, con) -> str.contains(con);
		System.out.println(contains.test("mumbai", "u"));
		
		Function<Integer, Integer> square = (x) -> x * x;
		System.out.println(square.apply(5));
		
		BiFunction<Integer, Integer, Integer> greater =
				(a, b) -> a > b ? a : b;
		System.out.println(greater.apply(10, 20));
	}
}
