package br.com.tesla.manufacture.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_flow_process", schema = "manufacture")
public class FlowProcess{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_flow_process")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cd_flow", referencedColumnName = "ci_flow")
	private Flow flow;

	@ManyToOne
	@JoinColumn(name = "cd_process", referencedColumnName = "ci_process")
	private Process process;
	
	@Column(name = "nr_order")
	private Integer order;

	
}