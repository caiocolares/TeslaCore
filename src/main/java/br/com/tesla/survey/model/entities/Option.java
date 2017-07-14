package br.com.tesla.survey.model.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "tb_option", schema = "survey")
public class Option {

	@Id 
	@Column(name="ci_option")
	private String id = UUID.randomUUID().toString();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cd_question",referencedColumnName="ci_question")
	private Question question;
	
	@Column(name="ds_option")
	private String description;
	
	/**
	 * Value to analyze in result report 
	 */
	@Column(name="ds_value")
	private String value;
	
}
