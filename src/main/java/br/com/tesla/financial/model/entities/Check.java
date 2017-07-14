package br.com.tesla.financial.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="tb_check",schema="financial")
public class Check extends Receivable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="cd_bank",referencedColumnName="ci_bank")
	private Bank bank;
	
	@Column(name="nr_agency")
	private String agency;
	
	@Column(name="nr_account")
	private String accountNumber;
	
	@Column(name="nr_check")
	private String number;
	
	@Column(name="nr_cpf")
	private String holderCpf;
	
	@Column(name="nm_holder")
	private String holderName;
	
	@ManyToOne
	@JoinColumn(name="cd_account", referencedColumnName="ci_account")
	private Account account;

}
