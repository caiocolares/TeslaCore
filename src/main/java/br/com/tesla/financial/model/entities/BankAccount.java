package br.com.tesla.financial.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

@Entity
@Table(name = "tb_bank_account", schema = "financial")
public class BankAccount {

	@EmbeddedId
	private BankAccountId id;

	@Column(name = "nm_account")
	private String name;

	@Column(name = "dt_start")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date startAccount;

	@Column(name = "dt_end")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date endAccount;

	@Column(name = "nr_limit")
	private BigDecimal limit;

	@ManyToOne
	@JoinColumn(name = "cd_bank", referencedColumnName = "ci_bank", updatable = false, insertable = false)
	private Bank bank;

}
