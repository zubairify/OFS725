import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptionDemo {
	public static void main(String[] args) throws Exception {
		
		// Generating AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);	// 128 bit key 
        SecretKey secretKey = keyGen.generateKey();
        
        System.out.println("Secret Key: " + secretKey.getEncoded());
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

        // Generate a random IV (Initialization vector) for each encryption
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16]; // GCM recommended IV size is 12 bytes
        random.nextBytes(iv);
        
        int tagLength = 128; // Authentication tag length in bits (e.g., 128, 96, or 64)

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(tagLength, iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);

        byte[] plainText = "P@ssw0rd123.".getBytes();
        byte[] cipherText = cipher.doFinal(plainText);

        System.out.println("Cipher Text: " + new String(cipherText));
        System.out.println("Encrypted text: " + Base64.getEncoder().encodeToString(cipherText)); 

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
        byte[] decryptedText = cipher.doFinal(cipherText);

        System.out.println("Decrypted Text: " + new String(decryptedText));
        
    }
}
