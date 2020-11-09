package com.demo.AES;

public class TestMain {
    public static void main(String[] args) {
        final String secretKey = "123456";

        String originalString = "nguyenvandat";
        String encryptedString = AES.encrypt(originalString, secretKey);
        String decryptedString = AES.decrypt(encryptedString, secretKey);

        System.out.println("Ma hoa: ");
        System.out.println(encryptedString);
        System.out.println("Giai ma: ");
        System.out.println(decryptedString);
    }
}
