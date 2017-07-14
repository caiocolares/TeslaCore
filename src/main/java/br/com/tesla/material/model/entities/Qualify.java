package br.com.tesla.material.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "tb_qualify", schema = "material")
public class Qualify{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_qualify")
	private Integer id;

	@Column(name = "nm_qualify",length=50)
	private String name;

	@Column(name = "ds_code",length=20)
	private String code;

	@Column(name="nr_order")
	private Integer order;
	
	@JsonIgnore
	@Transient
	public static Qualify nullQualify(){
		return Qualify.builder().id(0).name("").build();
	}
	
}