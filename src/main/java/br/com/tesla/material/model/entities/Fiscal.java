package br.com.tesla.material.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_material_fiscal",schema="material")
public class Fiscal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_fiscal")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="cd_material",referencedColumnName="ci_material")
	private Material material;
	
	@Column(name="nr_ncm", length=25)
	private String ncm;
	
}
