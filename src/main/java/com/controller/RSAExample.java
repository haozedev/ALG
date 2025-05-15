package com.controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAExample {
    public static void main(String[] args) {
        try {
            // 生成密钥对
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 要加密的数据
            String originalText = "明文数据";

            // 公钥加密
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = encryptCipher.doFinal(originalText.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("公钥加密后的密文：" + encryptedText);

            // 私钥解密
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("私钥解密后的明文：" + decryptedText);

            // 私钥签名
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(originalText.getBytes());
            byte[] signatureBytes = signature.sign();
            String signatureText = Base64.getEncoder().encodeToString(signatureBytes);
            System.out.println("私钥签名：" + signatureText);

            // 公钥验证签名
            Signature verifySignature = Signature.getInstance("SHA256withRSA");
            verifySignature.initVerify(publicKey);
            verifySignature.update(originalText.getBytes());
            boolean isVerified = verifySignature.verify(Base64.getDecoder().decode(signatureText));
            System.out.println("公钥验证签名结果：" + isVerified);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
