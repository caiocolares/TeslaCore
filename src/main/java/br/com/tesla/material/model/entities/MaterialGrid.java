package br.com.tesla.material.model.entities;

import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name="tb_material_grid",schema="material")
public class MaterialGrid {
	
	@EmbeddedId
	private MaterialGridId id;
	
	@ManyToOne
	@JoinColumn(name="cd_material",referencedColumnName="ci_material",insertable=false,updatable=false)
	private Material material;
	
	@ManyToOne
	@JoinColumn(name="cd_dimension_horizontal",referencedColumnName="ci_qualify",insertable=false,updatable=false)
	private Qualify dimensionHorizontal;
	
	@ManyToOne
	@JoinColumn(name="cd_dimension_vertical",referencedColumnName="ci_qualify",insertable=false,updatable=false)
	private Qualify dimensionVertical;

	@OneToMany
	@JoinColumns({@JoinColumn(name="cd_material"),
					@JoinColumn(name="cd_dimension_horizontal"),
					@JoinColumn(name="cd_dimension_vertical")})
	@MapKeyJoinColumn(name="cd_process",referencedColumnName="ci_process")
	private Map<br.com.tesla.manufacture.model.entities.Process,MaterialsByProcess> billOfMaterials;
	
}
