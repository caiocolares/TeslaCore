package br.com.tesla.financial.model.entities;

public enum LaunchDocumentType {

	SEQUENCIAL(true,true), NUMERIC(false,true), ALPHANUMERIC(false,false);
	
	private LaunchDocumentType(boolean generated, boolean numeric){
		this.generated = generated;
		this.numeric = numeric;
	}
	
	private boolean generated;
	
	private boolean numeric;
	
	public boolean isGenerated(){
		return this.generated;
	}
	
	public boolean isNumeric(){
		return this.numeric;
	}

}