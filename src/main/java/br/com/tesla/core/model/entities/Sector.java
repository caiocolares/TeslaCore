package br.com.tesla.core.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_sector",schema="core")
public class Sector {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_sector")
	private Integer id;
	
	@Column(name="nm_sector")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cd_workgroup",referencedColumnName="ci_workgroup")
	private WorkGroup workgroup;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="cd_sector",referencedColumnName="ci_sector")
	private Sector headOffice;
	
	@OneToMany(mappedBy="headOffice")
	private List<Sector> subsidiarys;
	
	@OneToMany(mappedBy="sector")
	private List<Lotation> lotations;
	
}
