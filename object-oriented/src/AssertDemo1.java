
public class AssertDemo1 {

	public static void main(String[] args) {
		int age = 20;
		assert age >= 18 : "Not Valid";
		
		System.out.println("Age: " + age);
	}
}
