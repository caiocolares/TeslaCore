package br.com.tesla.financial.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name="tb_duplicate_contract",schema="financial")
public class DuplicateContract {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_duplicate_contract")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="cd_account",referencedColumnName="ci_account")
	private Account account;
	
	@Column(name="dt_start_contract")
	@Temporal(TemporalType.DATE)
	private Date startContract;
	
	@Column(name="cd_banking_book")
	private String bankingBook;
	
	@Column(name="nr_interest")
	private BigDecimal interest;
	
	@Column(name="nr_penaulty")
	private BigDecimal penalty;
	
	@Column(name="nr_days_for_protest")
	private Integer daysForProtest;
	
	@Column(name="ds_message")
	private String message;
	
}
