package br.com.tesla.auth.model.entities;

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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(of = "label")
@Entity
@Table(name = "tb_transaction", schema = "core")
public class Transaction{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_transaction")
	private Integer id;

	@Column(name = "nm_transaction", length = 50)
	private String name;

	@Column(name = "nm_label", length = 80)
	private String label;

	@ManyToOne
	@JoinColumn(name="cd_resource",referencedColumnName="ci_resource")
	private ModuleResource moduleResource;

}