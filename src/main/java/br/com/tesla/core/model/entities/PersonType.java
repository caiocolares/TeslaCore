package br.com.tesla.core.model.entities;

public enum PersonType {
	
	FISICA("FÍSICA"),
	JURIDICA("JURÍDICA"),
	MISTA("MISTA");
	
	private String name;
	
	private PersonType(String name){		
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
}