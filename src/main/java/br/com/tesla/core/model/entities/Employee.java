package br.com.tesla.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_employee", schema = "core")
public class Employee {

	@Id
	@Column(name = "ci_employee", length = 50)
	private String id;

	/**
	 * Matrícula
	 */
	@Column(name = "nr_enrollment", length = 20)
	private String enrollment;

	/**
	 * Cargo
	 */
	@ManyToOne
	@JoinColumn(name = "cd_role", referencedColumnName = "ci_role")
	private Role role;

	/**
	 * Lotação
	 */
	@ManyToOne
	@JoinColumn(name = "cd_workgroup", referencedColumnName = "ci_workgroup")
	protected WorkGroup workgroup;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ci_employee", referencedColumnName = "ci_person", updatable = false, insertable = false)
	private Person person;

	@Column(name = "fl_enabled")
	private Boolean enabled;

}