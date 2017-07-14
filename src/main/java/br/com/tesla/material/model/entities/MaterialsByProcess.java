package br.com.tesla.material.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="tb_material_by_process",schema="material")
public class MaterialsByProcess {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_material_by_process")
	private Integer id;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="cd_material"),
					@JoinColumn(name="cd_dimension_horizontal"),
					@JoinColumn(name="cd_dimension_vertical")})
	private MaterialGrid materialGrid;
	
	@ManyToOne
	@JoinColumn(name="cd_process",referencedColumnName="ci_process")
	private br.com.tesla.manufacture.model.entities.Process process;
	
	
	@ManyToMany
	@JoinTable(name="tb_bill_of_materials",schema="material",
				joinColumns={@JoinColumn(name="cd_material_by_process",referencedColumnName="ci_material_by_process")},
				inverseJoinColumns={@JoinColumn(name="cd_material_child",referencedColumnName="cd_material"),
							@JoinColumn(name="cd_dimension_horizontal_child",referencedColumnName="cd_dimension_horizontal"),
							@JoinColumn(name="cd_dimension_vertical_child",referencedColumnName="cd_dimension_vertical")})		
	private List<MaterialGrid> list;
	
}
