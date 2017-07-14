package br.com.tesla.auth.model.entities;

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

@NoArgsConstructor(access=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Builder
@Data
@Entity
@Table(name = "tb_resource", schema = "core")
public class ModuleResource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_resource")
	private Integer id;

	@Column(name = "nm_resource", length = 50)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="cd_module",referencedColumnName="ci_module")
	private Module module;

}
