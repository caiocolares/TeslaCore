package br.com.tesla.financial.model.entities;

public enum LaunchType {

	CREDIT(true, false),DEBIT(false, true);
	
	private LaunchType(boolean credit, boolean debit){
		this.credit = credit;
		this.debit = debit;
	}
	
	private boolean credit;
	
	private boolean debit;
	
	public boolean isCredit(){
		return this.credit;
	}
	
	public boolean isDebit(){
		return this.debit;
	}
	
}