import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TestLifeCycle {
	private List<String> cart;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Setup before all test cases");
	}
	
	@AfterAll
	public static void teardown() {
		System.out.println("Teardown after all test cases");
	}
	
	@BeforeEach
	public void setupEach() {
		cart = new ArrayList<String>();
		cart.add("Kiwi");
		System.out.println("Setup before each test case");
	}
	
	@AfterEach
	public void teardownEach() {
		cart = null;
		System.out.println("Teardown after each test case");
	}
	
//	@Disabled
	@Test
	public void testEmptyCart() {
		System.out.println("Testing empty cart");
		assertTrue(cart.isEmpty());
	}
	
	@Test
	public void testOneItem() {
		cart.add("Apple");
		System.out.println("Testing cart with 1 item");
		assertEquals(1, cart.size());
	}
}
