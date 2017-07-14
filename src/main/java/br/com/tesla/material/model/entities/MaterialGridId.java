package br.com.tesla.material.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MaterialGridId implements Serializable {

	private static final long serialVersionUID = 1273573197218535380L;

	@Column(name="cd_material")
	private String materialId;
	
	@Column(name="cd_dimension_horizontal")
	private String dimensionHorizontalId;
	
	@Column(name="cd_dimension_vertical")
	private String dimensionVerticalId;

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getDimensionHorizontalId() {
		return dimensionHorizontalId;
	}

	public void setDimensionHorizontalId(String dimensionHorizontalId) {
		this.dimensionHorizontalId = dimensionHorizontalId;
	}

	public String getDimensionVerticalId() {
		return dimensionVerticalId;
	}

	public void setDimensionVerticalId(String dimensionVerticalId) {
		this.dimensionVerticalId = dimensionVerticalId;
	}
	
}
