import java.security.MessageDigest;
import java.util.Base64;

public class SHA256HashingDemo {
	
	public static void main(String[] args) throws Exception {
		
        String original = "Password123";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        byte[] originalHash = digest.digest(original.getBytes());
        System.out.println("SHA-256 Hash - Original: " +
                Base64.getEncoder().encodeToString(originalHash));
        
        String tempered = "password321";
        byte[] temperedHash = digest.digest(tempered.getBytes());
        System.out.println("SHA-256 Hash - Tempered: " +
                Base64.getEncoder().encodeToString(temperedHash));
        
        System.out.println(originalHash.equals(originalHash));
        System.out.println(originalHash.equals(temperedHash));
    }

}
