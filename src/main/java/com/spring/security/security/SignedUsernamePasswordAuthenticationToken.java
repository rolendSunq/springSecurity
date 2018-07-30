package com.spring.security.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class SignedUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -6027433972338239799L;
	private String requestSignature;
	
	public SignedUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
	
	public SignedUsernamePasswordAuthenticationToken(String principal, String credentials, String signature) {
		super(principal, credentials);
		requestSignature = signature; 
	}

	public String getRequestSignature() {
		return requestSignature;
	}

	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}
	
}
