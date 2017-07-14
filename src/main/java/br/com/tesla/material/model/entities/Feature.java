package br.com.tesla.material.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "tb_feature", schema = "material")
public class Feature{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_feature")
	private Integer id;

	@Column(name = "nm_feature",length=50)
	private String name;

	@Column(name = "fl_required")
	private Boolean required;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_type",length=50)
	private FeatureType featureType = FeatureType.ADDITIONAL;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "fl_grid_type",length=50)
	private GridType gridType = GridType.NONE;

	@Column(name = "ds_code", length = 20)
	private String code;

	@ManyToMany
	@JoinTable(name = "tb_feature_qualify", schema = "material", 
			  joinColumns = {@JoinColumn(name = "cd_feature", referencedColumnName = "ci_feature", 
			                             nullable = false, updatable = false) }, 
			  inverseJoinColumns = {@JoinColumn(name = "cd_qualify", referencedColumnName = "ci_qualify", 
			  						nullable = false, updatable = false) })
	private List<Qualify> qualifies;

}