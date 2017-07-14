package br.com.tesla.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_role_skill", schema = "core")
public class Skill{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_skill")
	private Integer id;

	@Column(name = "nm_skill", length = 50)
	private String name;

	@ManyToOne
	@JoinColumn(name = "cd_role", referencedColumnName = "ci_role")
	private Role role;

}