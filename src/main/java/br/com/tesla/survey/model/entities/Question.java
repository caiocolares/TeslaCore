package br.com.tesla.survey.model.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "tb_question", schema = "survey")
public class Question {
	
	@Id 
	@Column(name="ci_question")
	private String id = UUID.randomUUID().toString();
	
	@Column(name="ds_question")
	private String description;
	
	@Column(name="nr_order")
	private Integer order;
	
	@Column(name="fl_multiselection")
	private Boolean multiselection = false;
	
	@Column(name="fl_complementar_answer")
	private Boolean complementarAnswer = false;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private List<Option> options;

}
