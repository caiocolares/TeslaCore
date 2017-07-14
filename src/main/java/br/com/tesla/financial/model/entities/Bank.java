package br.com.tesla.financial.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_bank",schema="financial")
public class Bank {
	
	@Id @Column(name="ci_bank")
	private Integer id;
	
	@Column(name="nm_bank")
	private String name;
	
	@Column(name="ds_bank")
	private String alias;
	
	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name="ds_site")
	private String site;
	
}
