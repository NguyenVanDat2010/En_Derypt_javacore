package com.demo.RSA;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Decryption {
    public static void decrypt() {
        try {
            // Đọc file chứa private key
            FileInputStream fis = new FileInputStream("D:\\CRYPPT\\demo1\\src\\com\\demo\\RSA/privateKey.txt");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();
            System.out.println("dsdfsd"+Arrays.toString(b));

            // Tạo private key
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            // Giải mã dữ liệu
            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(Encrpytion.encrypt()));
            System.out.println("Dữ liệu sau khi giải mã: " + new String(decryptOut));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
