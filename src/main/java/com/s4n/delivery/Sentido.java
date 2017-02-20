package com.s4n.delivery;

public enum Sentido {

	NORTE("Norte"),
	SUR("Sur"),
	ORIENTE("Oriente"),
	OCCIDENTE("Occidente");
	
	private String sentido;
	
	private Sentido(){
		this.sentido = "Norte";
	}
	
	private Sentido(String sentido){
		this.sentido = sentido;
	}
	
	public String getSentido() {
		return sentido;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	
}
