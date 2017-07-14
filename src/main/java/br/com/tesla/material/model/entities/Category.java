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
@Table(name = "tb_category", schema = "material")
public class Category{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_category")
	private Integer id;

	@Column(name = "nm_category")
	private String name;
	
	/*
	 * private Feature horizontalFeature;
	 * 
	 * private Feature verticalFeature;
	 * 
	 */

	@ManyToMany
	@JoinTable(name = "tb_category_feature", schema = "material", 
			   joinColumns = {@JoinColumn(name = "cd_category", referencedColumnName = "ci_category", 
			                              nullable = false, updatable = false) }, 
			   inverseJoinColumns = {@JoinColumn(name = "cd_feature", referencedColumnName = "ci_feature", 
			                                     nullable = false, updatable = false) })	
	private List<Feature> features;
	
	public void addFeature(Feature feature){
		if(!feature.getGridType().equals(GridType.NONE)){
			for(Feature f : features){
				if(f.getGridType().equals(feature.getGridType())){
					throw new RuntimeException(String.format( "Só é permitido uma característica na dimensão %s ",feature.getGridType().toString()));
				}
			}
		}
		this.features.add(feature);
	}

}
