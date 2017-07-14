package br.com.tesla.survey.model.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.tesla.core.model.entities.PersonGender;
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
@Table(name = "tb_interviewed", schema = "survey")
public class Interviewed {
	
	@Id 
	@Column(name="ci_interviewed")
	private String id =UUID.randomUUID().toString();
	
	@Column(name="nm_interviewed")
	private String name;
	
	@Column(name="ds_email")
	private String email;
	
	@Column(name="fl_gender")
	@Enumerated(EnumType.STRING)
	private PersonGender gender = PersonGender.MASCULINO;
	
	@Column(name="ds_observation")
	private String observation;
}
