package br.com.tesla.core.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "tb_role", schema = "core")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_role")
	private Integer id;

	@Column(name = "nm_role", length = 50)
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_master", referencedColumnName = "ci_role")
	private Role master;

	@OneToMany(mappedBy = "master")
	private List<Role> childs = new ArrayList<Role>();

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Duty> duties = new ArrayList<Duty>();

	@Column(name = "fl_education")
	@Enumerated(EnumType.STRING)
	private Education education = Education.INDEFINIDO;

	@Column(name = "ds_role", length = 500)
	private String description;

	@OneToMany( mappedBy = "role", cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Skill> skills = new ArrayList<Skill>();

}