package br.com.tesla.manufacture.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PACKAGE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder
@Entity
@Table(name = "tb_process", schema = "manufacture")
public class Process{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_process")
	private Integer id;

	@Column(name = "nm_process")
	private String name;

	@Column(name = "nr_order")
	private Integer order;

	@Column(name = "nm_color")
	private String color;

	/**
	 * Minutes
	 */
	@Column(name = "nr_capacity")
	private Integer capacity;

	/**
	 * Dias
	 */
	@Column(name = "nr_lead_time")
	private Integer leadTime;

}