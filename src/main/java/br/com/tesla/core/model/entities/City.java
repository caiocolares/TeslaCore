package br.com.tesla.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder
@Entity
@Table(name = "tb_city", schema = "core")
public class City {
	
	/**
	 * Código do IBGE
	 */
	@Id
	@Column(name = "ci_city")
	private Integer id;

	@Column(name = "nm_city", length = 60)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_uf", length = 2)
	private UF uf;

}