package br.com.tesla.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "tb_person_address", schema = "core")
public class Address {
	
	@Id
	@Column(name = "ci_address", length = 50)
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_street_type", length = 10)
	private AddressStreetType streetType;

	@Size(min=8,max=8,message="CEP deve possuir 8 dígitos!")
	@Column(name = "nr_zipcode", length = 9)
	private String zipCode;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "fl_type", length = 12)
	private AddressType addressType;

	@Column(name = "nr_latitude")
	private Double latitude;

	@Column(name = "nr_longitude")
	private Double longitude;

	@Column(name = "nr_order")
	private Integer order;

	/**
	 * Nome do Logradouro
	 */
	@Column(name = "nm_patio", length = 80)
	private String patio;

	@Column(name = "nr_number", length = 10)
	private String number;

	@Column(name = "ds_complement", length = 50)
	private String complement;

	/**
	 * Nome do Bairro
	 */
	@Column(name = "nm_district", length = 100)
	private String district;

	@Column(name = "nm_reference", length = 50)
	private String reference;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_city", referencedColumnName = "ci_city")
	private City city;
	
	@Column(name="fl_uf",length=2)
	private String uf;
	
	@JsonIgnore
	public String getName() {
		return this.streetType.toString() + " " + this.patio + ", " + this.number;
	}

}