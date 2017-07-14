package br.com.tesla.survey.model.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.tesla.auth.model.entities.User;
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
@Table(name = "tb_form", schema = "survey")
public class Form {
	
	@Id 
	@Column(name="ci_form")
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="cd_quiz",referencedColumnName="ci_quiz")
	private Quiz quiz;
	
	@ManyToOne
	@JoinColumn(name="cd_user",referencedColumnName="ci_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="cd_interviewed",referencedColumnName="ci_interviewed")
	private Interviewed interviewed;
	
	@Column(name="dt_start")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@OneToMany
	@JoinColumn(name="cd_form",referencedColumnName="ci_form")
	private List<Answer> answers;

}
