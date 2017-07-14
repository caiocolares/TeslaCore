package br.com.tesla.material.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@NoArgsConstructor(access=AccessLevel.PACKAGE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder

@Entity
@Table(name = "tb_material_feature", schema = "material")
public class MaterialQualify {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_material_feature")
	private Integer id;
	
	@Column(name = "cd_material")
	private String material;

	@ManyToMany
	@JoinTable(name = "tb_material_qualify", schema = "material", 
			   joinColumns = {@JoinColumn(name = "cd_material_feature", referencedColumnName = "ci_material_feature") }, 
			   inverseJoinColumns = {@JoinColumn(name = "cd_qualify", referencedColumnName = "ci_qualify") })	
	private List<Qualify> qualify;
	
	@Column(name="ds_complement")
	private String complement;
	
}
