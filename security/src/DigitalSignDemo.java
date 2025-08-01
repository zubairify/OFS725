import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DigitalSignDemo {
	
	public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println("Public Key: " +
                Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("Private Key: " +
                Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        
        String message = "This is a signed message";
        signature.update(message.getBytes());
        byte[] signedData = signature.sign();
        System.out.println("Digital Signature: " +
                Base64.getEncoder().encodeToString(signedData));
        
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        System.out.println(signature.verify(signedData));
        
        String tempMsg = "This is tempered message";
        signature.update(tempMsg.getBytes());
        System.out.println(signature.verify(signedData));
    }
}
