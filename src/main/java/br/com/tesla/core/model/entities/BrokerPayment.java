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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Entity
@Table(name = "tb_broker_payment", schema = "core")
public class BrokerPayment {

	@Tolerate
	private BrokerPayment(){}
	
	@Id
	@Column(name = "ci_broker_payment", length = 50)
	private String id;

	@Column(name = "cd_controller_erp")
	private Integer codeErp;
	
	@Column(name="nr_cnpj")
	private String cnpj;

	@Column(name = "cd_shop")
	private Integer shop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_broker", referencedColumnName = "ci_broker", insertable = false, updatable = false)
	private Broker broker;

	@Column(name = "cd_broker")
	private String brokerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_employee", referencedColumnName = "ci_employee", insertable = false, updatable = false)
	private Employee employee;

	@Column(name = "cd_employee")
	private String employeeId;

	@Column(name = "nr_authorization", length = 50)
	private String authorization;

	@Column(name = "nr_paymentType", length = 50)
	private String paymentType;

	@Column(name = "nr_bank")
	private Integer bank;

	@Column(name = "nr_agency")
	private Integer agency;

	@Column(name = "nr_account")
	private Integer account;

	@Column(name = "nr_check")
	private Integer check;

	@Column(name = "nr_amount")
	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_payment")
	private Date paymentDate;

	@Column(name = "bl_photo")
	@JsonSerialize(using = br.com.tesla.json.ByteArraySerializer.class)
	private byte[] photo;

}