package com.nowcoder.community.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author ying.zhang01
 */
public class RsaUtil {
    public static final String RSA_ALGORITHM = "RSA";

    /**
     * 创建RSA 公钥-私钥
     * @return
     */
    public static RsaKey createKeys(){
        return createKeys(1024);
    }

    /**
     * 创建RSA 公钥-私钥
     * @param keySize
     * @return
     */
    public static RsaKey createKeys(int keySize){
        //为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg = null;
        try{
            kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        //初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(keySize);
        //生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();

        //得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());

        //得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());

        RsaKey rsaKey = new RsaKey();
        rsaKey.setPublicKey(publicKeyStr);
        rsaKey.setPrivateKey(privateKeyStr);

        return rsaKey;
    }


    /**
     * 公钥加密
     * @param originalText 原文
     * @param publicKey
     * @return
     */
    public static String publicEncrypt(String originalText, String publicKey){
        RSAPublicKey rsaPublicKey = getPublicKey(publicKey);
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            return Base64.encodeBase64String(cipher.doFinal(originalText.getBytes(StandardCharsets.UTF_8)));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + originalText + "]时遇到异常", e);
        }
    }

    /**
     * 公钥解密
     * @param cipherText 密文
     * @param publicKey
     * @return
     */
    public static String publicDecrypt(String cipherText, String publicKey){
        RSAPublicKey rsaPublicKey = getPublicKey(publicKey);
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, rsaPublicKey);
            return Base64.encodeBase64URLSafeString(cipher.doFinal(cipherText.getBytes(StandardCharsets.UTF_8)));
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + cipherText + "]时遇到异常", e);
        }
    }

    /**
     * 私钥加密
     * @param originalText 原文
     * @param privateKey
     * @return
     */
    public static String privateEncrypt(String originalText, String privateKey){
        RSAPrivateKey rsaPrivateKey=  getPrivateKey(privateKey);

        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, rsaPrivateKey);
            return Base64.encodeBase64URLSafeString(cipher.doFinal(originalText.getBytes(StandardCharsets.UTF_8)));
        }catch(Exception e){
            throw new RuntimeException("加密字符串[" + originalText + "]时遇到异常", e);
        }
    }


    /**
     * 私钥解密
     * @param cipherText 密文
     * @param privateKey
     * @return
     */
    public static String privateDecrypt(String cipherText, String privateKey){
        RSAPrivateKey rsaPrivateKey=  getPrivateKey(privateKey);
        byte[] cipherBytes = Base64.decodeBase64(cipherText);
        try{
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
            return new String(cipher.doFinal(cipherBytes), StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException("解密字符串[" + cipherText + "]时遇到异常", e);
        }
    }

    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    private static RSAPublicKey getPublicKey(String publicKey) {
        //通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        RSAPublicKey key = null;
        try {
            key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * 得到私钥
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception
     */
    private static RSAPrivateKey getPrivateKey(String privateKey){
        //通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        RSAPrivateKey key = null;
        try {
            key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static void main(String[] args) {
        RsaKey rsaKey = RsaUtil.createKeys();

        System.out.println("公钥" );
        System.out.println(rsaKey.getPublicKey());
        System.out.println(rsaKey.getPublicKey());

        System.out.println("私钥");
        System.out.println(rsaKey.getPrivateKey());

        System.out.println("公钥加密——私钥解密");

        String str = "zhang ying";
        System.out.println("明文：" + str);

        //公钥加密
        String encodedData = RsaUtil.publicEncrypt(str, rsaKey.getPublicKey());
        System.out.println("公钥加密后密文：" + encodedData);

        //私钥解密
        String decodedData = RsaUtil.privateDecrypt(encodedData, rsaKey.getPrivateKey());
        System.out.println("私钥解密后文字: " + decodedData);
    }
}
