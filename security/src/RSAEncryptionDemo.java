import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryptionDemo {

	public static void main(String[] args) throws Exception {
//      1. Generate RSA Key Pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("Public Key: " +
                Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("Private Key: " +
                Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // 2. Original message
        String originalMessage = "This is a secret message.";
        System.out.println("\nOriginal Message: " + originalMessage);

        // 3. Encrypt the message using the Public Key
        Cipher encryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptCipher.doFinal(originalMessage.getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Message (Base64): " + encryptedMessage);

        // 4. Decrypt the message using the Private Key
        Cipher decryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(
                Base64.getDecoder().decode(encryptedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
