package br.com.tesla.financial.model.entities;

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

import br.com.tesla.core.model.entities.Person;
import lombok.Data;

@Data
@Entity
@Table(name="tb_millennium_config",schema="legacy")
public class MillenniumConfig {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_millennium_config")
	private Integer id;
	
	@Column(name="ds_url")
	private String url;
	
	@Column(name="ds_login")
	private String login;
	
	@Column(name="ds_password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="cd_launch_document",referencedColumnName="ci_launch_document")
	private LaunchDocument document;
	
	@ManyToOne
	@JoinColumn(name="cd_person",referencedColumnName="ci_person")
	private Person defaultCustomer;
	
	@Column(name="dt_last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
}
