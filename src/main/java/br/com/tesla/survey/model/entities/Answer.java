package br.com.tesla.survey.model.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tb_answer", schema = "survey")
public class Answer {

	@Id 
	@Column(name="ci_answer")
	private String id = UUID.randomUUID().toString();
	
	@ManyToMany
	@JoinTable(name="tb_answer_option",schema="survey", 
				inverseJoinColumns={@JoinColumn(name="cd_option", referencedColumnName="ci_option")},
				joinColumns={@JoinColumn(name="cd_answer",referencedColumnName="ci_answer")})
	private List<Option> options;

	@Column(name="ds_complement")
	private String complement;
	
}
