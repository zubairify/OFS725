import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class GCMEncryptionDemo {
	
	public static void main(String[] args) throws Exception {
        byte[] keyBytes = "ThisIsSecretKey123456789".getBytes(); // 128-bit key size 24 bytes
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        // Generate a random IV for each encryption
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[12]; // GCM recommended IV size is 12 bytes
        random.nextBytes(iv);

        int tagLength = 128; // Authentication tag length in bits (e.g., 128, 96, or 64)

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(tagLength, iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        byte[] plainText = "This is the plain text to be encrypted.".getBytes();
        byte[] cipherText = cipher.doFinal(plainText);

        System.out.println("Cipher Text: " + new String(cipherText));
        System.out.println("Encrypted text: " + Base64.getEncoder().encodeToString(cipherText)); 

        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
        byte[] decryptedText = cipher.doFinal(cipherText);

        System.out.println("Decrypted Text: " + new String(decryptedText));
    }
}
