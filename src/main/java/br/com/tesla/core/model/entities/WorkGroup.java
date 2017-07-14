package br.com.tesla.core.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "tb_workgroup", schema = "core")
public class WorkGroup {

	@Id
	@Column(name = "ci_workgroup", length = 50)
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_workgroup_type")
	private WorkGroupType workgroupType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_master", referencedColumnName = "ci_workgroup")
	private WorkGroup master;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "master")
	private List<WorkGroup> childs = new ArrayList<WorkGroup>();

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ci_workgroup", referencedColumnName = "ci_person", updatable = false, insertable = false)
	private Person person;

	@Column(name = "fl_enabled")
	private Boolean enabled;

}