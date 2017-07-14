package br.com.tesla.core.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Entity
@Table(name = "tb_broker_launch", schema = "core")
public class BrokerLaunch {

	@Tolerate
	private BrokerLaunch(){}
	
	@Id
	@Column(name = "ci_broker_comission", length = 50)
	private String id;

	@Column(name = "cd_controller_erp")
	private Integer codeErp;

	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name = "cd_shop")
	private Integer shop;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_broker", referencedColumnName = "ci_broker", insertable = false, updatable = false)
	private Broker broker;

	@Column(name = "cd_broker")
	private String brokerId;

	@Column(name = "nr_amount")
	private BigDecimal amount;

	@Column(name = "nr_aliquot")
	private BigDecimal aliquot;

	@Column(name = "nr_comission")
	private BigDecimal comission;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_launch")
	private Date launchDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_update")
	private Date lastUpdate = new Date();

	@Column(name = "cd_broker_payment", length = 50)
	private String paymentId;

}