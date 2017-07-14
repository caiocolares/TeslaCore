package br.com.tesla.material.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_specification",schema="material")
public class Specification {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_specification")
	private Integer id;
	
	@Column(name="nm_specification",length=50)
	private String name;
	
	@Column(name="fl_required")
	private Boolean required = true;
	
	@Column(name="fl_type",length=20)
	@Enumerated(EnumType.STRING)
	private SpecificationType specificationType = SpecificationType.STRING;
}
