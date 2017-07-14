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


@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder
@Entity
@Table(name = "tb_zip_code", schema = "core")
public class ZipCode {

	@Id
	@Column(name = "ci_zip_code")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "cd_uf", length = 2)
	private UF uf;

	@Column(name = "cd_city", length = 60)
	private String city;

	@Column(name = "ds_district", length = 100)
	private String district;

	@Column(name = "ds_patio", length = 80)
	private String patio;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_type_patio", length = 10)
	private AddressStreetType streetType;
	

}