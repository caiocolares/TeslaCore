package br.com.tesla.core.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(of="id")
@Entity
@Table(name = "tb_customer", schema = "core")
public class Customer {

	@Id
	@Column(name = "ci_customer", length = 50)
	private String id;

	@Column(name = "nr_credit_limit")
	private BigDecimal creditLimit;

	@Column(name = "ds_observation", length = 250)
	private String observation;

	@Column(name = "ds_status", length = 20)
	private String status;

	@Column(name = "fl_enabled")
	private Boolean enabled;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ci_customer", referencedColumnName = "ci_person", updatable = false, insertable = false)
	private Person person;

}