import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CipherDecrypt {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
       
        Day.stream().filter(d -> d.getVal().equals("off")).forEach(System.out::println);
        
        Signature sign = Signature.getInstance("SHA256withRSA");
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();   
        KeyPair pair1 = keyPairGen.generateKeyPair();   
        PublicKey publicKey = pair1.getPublic();
        System.out.println(publicKey.toString());
        System.out.println(pair.getPrivate().toString());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        byte[] input = "NEEL JAIN".getBytes();    
        cipher.update(input);
        byte[] cipherText = cipher.doFinal();
        System.out.println( new String(cipherText));
        
        Cipher cipher1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        PrivateKey private1 = pair1.getPrivate();
        cipher1.init(Cipher.DECRYPT_MODE, private1);
        byte[] decipheredText = cipher1.doFinal(cipherText);
        System.out.println(new String(decipheredText));

    }
}
