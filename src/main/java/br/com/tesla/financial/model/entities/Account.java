package br.com.tesla.financial.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.tesla.core.model.entities.WorkGroup;
import lombok.Data;

@Data
@Entity
@Table(name="tb_account",schema="financial")
public class Account {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_account")
	private Integer id;
	
	@Column(name="nm_account")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cd_workgroup",referencedColumnName="ci_workgroup")
	private WorkGroup workgroup;
	
	@OneToOne(optional=true)
	@JoinColumns({@JoinColumn(name="cd_bank", referencedColumnName="cd_bank"),
					@JoinColumn(name="cd_agency", referencedColumnName="cd_agency"),
					@JoinColumn(name="nr_account", referencedColumnName="nr_account")})
	private BankAccount bankAccount;

	@Column(name = "fl_active")
	private Boolean active;
	
}
