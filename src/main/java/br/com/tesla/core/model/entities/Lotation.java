package br.com.tesla.core.model.entities;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
@Table(name="tb_lotation",schema="core")
public class Lotation {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_lotation")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cd_person",referencedColumnName="ci_person")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="cd_role",referencedColumnName="ci_role")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="cd_sector",referencedColumnName="ci_sector")
	private Sector sector;
	
	@Column(name="dt_start")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date startLotation;
	
	@Column(name="dt_end")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date endLotation;
	
}
