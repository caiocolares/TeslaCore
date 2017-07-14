package br.com.tesla.core.model.entities;

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

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_broker", schema = "core")
public class Broker {

	@Id
	@Column(name = "ci_broker", length = 50)
	private String id;

	@Column(name = "nr_code")
	private Integer code;
	
	@Column(name = "ds_observation", length = 250)
	private String observation;

	@Column(name = "fl_enabled")
	private Boolean enabled;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ci_broker", referencedColumnName = "ci_person", updatable = false, insertable = false)
	private Person person;

	/**
	 * Supervisor of (preposto)
	 */
	//	@Column(name = "cd_helper")
	//	private Integer helperCode;
	// @JsonIgnore
	// @OneToMany(fetch = FetchType.LAZY)
	// @JoinColumn(name = "cd_broker", referencedColumnName = "ci_broker")
	// private List<Broker> brokers;
	//
	// @Column(name = "cd_broker")
	// private String master;
	//
	// public List<Broker> getBrokers() {
	// try {
	// brokers.isEmpty();
	// return brokers;
	// } catch (Exception e) {
	// brokers = new ArrayList<>();
	// return brokers;
	// }
	// }

}