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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "tb_person_phone", schema = "core")
public class Phone {

	@Id
	@Column(name = "ci_phone", length = 50)
	private String id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fl_type", length = 12)
	private PhoneType phoneType;

	@Column(name = "nr_company", length = 20)
	private String company;

	@Column(name = "nr_ddd", length = 2)
	private String ddd;

	@Column(name = "nr_number", length = 10)
	private String number;

	@Column(name = "nr_order")
	private Integer order;

}