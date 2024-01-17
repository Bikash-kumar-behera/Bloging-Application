package com.pns.spring.service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pns.spring.model.EncryptedDto;

public class SecretUtilsService {

	//Encryption
    public static EncryptedDto aesGcmEncryptToBase64(String key, Object data){
        byte[] nonce = generateRandomNonce();
        SecretKeySpec secretKeySpec = new SecretKeySpec(base64Decoding(key), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, nonce);
        EncryptedDto encryptedDto = null;
        try {
        	Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, gcmParameterSpec);
        	String dataString = new ObjectMapper().writeValueAsString(data);
            byte[] ciphertextWithTag = cipher.doFinal(dataString.getBytes(StandardCharsets.UTF_8));
            byte[] ciphertext = new byte[(ciphertextWithTag.length-16)];
            byte[] gcmTag = new byte[16];
            System.arraycopy(ciphertextWithTag, 0, ciphertext, 0, (ciphertextWithTag.length - 16));
            System.arraycopy(ciphertextWithTag, (ciphertextWithTag.length-16), gcmTag, 0, 16);
            String nonceBase64 = base64Encoding(nonce);
            String ciphertextBase64 = base64Encoding(ciphertext);
            String gcmTagBase64 = base64Encoding(gcmTag);
            
            encryptedDto = new EncryptedDto();
            
            encryptedDto.setIv(nonceBase64);
            encryptedDto.setEncryptedMessage(ciphertextBase64);
            encryptedDto.setAuthTag(gcmTagBase64);
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
		} catch (GeneralSecurityException e) {
			System.err.println(e.getMessage());
		}
        return encryptedDto;
    }

    private static byte[] generateRandomNonce() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] nonce = new byte[12];
        secureRandom.nextBytes(nonce);
        return nonce;
    }
    
    private static String base64Encoding(byte[] input) {
        return Base64.getEncoder().encodeToString(input);
    }

    //de-cryption
    
	public static Object aesGcmDecryptFromBase64(String key, EncryptedDto encrypted) {
		byte[] nonce = base64Decoding(encrypted.getIv());
		byte[] ciphertext = base64Decoding(encrypted.getEncryptedMessage());
		byte[] gcmTag = base64Decoding(encrypted.getAuthTag());
		byte[] encryptedData = concatenateByteArrays(ciphertext, gcmTag);
		Object decryptedData = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
			SecretKeySpec secretKeySpec = new SecretKeySpec(base64Decoding(key), "AES");
			GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(16 * 8, nonce);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, gcmParameterSpec);
			String decryptedString = new String(cipher.doFinal(encryptedData));
			decryptedData = new JSONParser().parse(decryptedString);
		}catch(ParseException pe) {
			System.err.println(pe.getMessage());
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return decryptedData;
	}

	public static byte[] concatenateByteArrays(byte[] a, byte[] b) {
		return ByteBuffer.allocate(a.length + b.length).put(a).put(b).array();
	}

    private static byte[] base64Decoding(String input) {
        return Base64.getDecoder().decode(input);
    }
}
