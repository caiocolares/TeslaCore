package br.com.tesla.survey.model.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "tb_quiz", schema = "survey")
public class Quiz {
	
	@Id
	@Column(name="ci_quiz")
	private String id = UUID.randomUUID().toString();
	
	@Column(name="nm_quiz")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cd_user",referencedColumnName="ci_user")
	private User user;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="dt_start")
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="dt_end")
	@Temporal(TemporalType.DATE)
	private Date end;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_quiz",referencedColumnName="ci_quiz")
	private List<Question> questions;
	
}
