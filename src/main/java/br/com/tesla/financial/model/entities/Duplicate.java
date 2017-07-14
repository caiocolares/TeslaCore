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
@Table(name="tb_duplicate",schema="financial")
public class Duplicate extends Receivable {

	private static final long serialVersionUID = 5554842311202282092L;

	@Column(name="nr_our_number")
	private String ourNumber;

	@ManyToOne
	@JoinColumn(name="cd_duplicate_contract", referencedColumnName="ci_duplicate_contract")
	private DuplicateContract contract;
	
}
