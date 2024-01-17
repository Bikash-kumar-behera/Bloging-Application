package com.pns.spring.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EncryptedDto {
	private String iv;
	private String authTag;
	private String encryptedMessage;
	
}
