package com.example.logicprogram.other_java;

import com.google.crypto.tink.subtle.AesCmac;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class TestingAES {

    // Test Bytes - 16 bytes
    static byte[] testInput = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};

    // Test key - 16 bytes, 128-bit
    static byte[] keyBytes = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f};

    // Test nonce - 13 bytes, 104-bit
    static byte[] nonce = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
            0x0a, 0x0b, 0x0c};

    public static void main(String[] args) {

        String str = "test";
        byte[] bytesInput = str.getBytes();





        Security.getProvider("BC");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(16, nonce);
        Cipher cipher = null;
        try {

            KeyGenerator aes = KeyGenerator.getInstance("AES");
            aes.init(256);
            SecretKey secretKey = aes.generateKey();

            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey/*secretKeySpec*//*, parameterSpec*/);
            //cipher.updateAAD(new byte[]{0x01});

            System.out.println(DatatypeConverter.printHexBinary(cipher.doFinal(bytesInput)));

            try {

                KeyGenerator aes1 = KeyGenerator.getInstance("AES");
                AesCmac aesCmac = new AesCmac(aes1.getAlgorithm().getBytes(), 16);
                byte[] bytes = aesCmac.computeMac(bytesInput);
                System.out.println(DatatypeConverter.printHexBinary(cipher.doFinal(bytes)));
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } /*catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }*/ catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}
