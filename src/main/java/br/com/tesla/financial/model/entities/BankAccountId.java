package br.com.tesla.financial.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BankAccountId  implements Serializable{

	private static final long serialVersionUID = -2319282249467934003L;
	
	@Column(name="cd_bank")
	private Integer bank;
	@Column(name="cd_agency")
	private Integer agency;
	@Column(name="nr_account")
	private String account;
	
	public Integer getBank() {
		return bank;
	}
	public void setBank(Integer bank) {
		this.bank = bank;
	}
	public Integer getAgency() {
		return agency;
	}
	public void setAgency(Integer agency) {
		this.agency = agency;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
