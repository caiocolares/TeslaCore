package br.com.tesla.material.model.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import br.com.tesla.manufacture.model.entities.Flow;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The view for this entity must be like a wizard, because 
 *     must obey some steps:
 *     1 - Register number of pieces with description of parts;
 *     2 - Register Process Flow for each part (can be a lazy process, but dependent of register number 1);
 *     3 - Register Bill of Materials (BOM) for each part (can be a lazy process, but dependent of register number 2);
 *     4 - Register operations for each process for each part (can be a lazy process, but dependent of register number 2);
 *     5 - Register specifications for each part (can be a lazy process,but dependent of register number 2);
 *     6 - Approve coast and price (can be a lazy process, but dependent of register number 3 and 4);
 *     
 *     Just after this steps the material be able to operate.
 *     
 * @author CaioColares
 *
 */

@NoArgsConstructor(access=AccessLevel.PACKAGE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder

@Entity
@Table(name = "tb_material", schema = "material")
public class Material {

	@Id
	@Column(name="ci_material")
	private String id;
	
	@Column(name="nr_code",length=20)
	private String code;
	
	@Column(name = "nm_material", length=50)
	private String name;

	@Column(name = "ds_description",length=100)
	private String description;

	@Column(name="nr_pieces")
	private Integer pieces = 1;
	
	@ManyToOne
	@JoinColumn(name = "cd_category", referencedColumnName = "ci_category")
	private Category category;

	@ManyToMany
	@JoinTable(name="tb_material_flow", schema="material",
				inverseJoinColumns={@JoinColumn(name = "cd_flow", referencedColumnName = "ci_flow")},
				joinColumns={@JoinColumn(name="cd_material",referencedColumnName="ci_material")})
	@MapKeyJoinColumn(name="nr_piece")
	private Map<Integer,Flow> flow;
	
	@OneToMany
	@JoinColumn(name = "cd_material", referencedColumnName = "ci_material")			
	@MapKeyJoinColumn(name="cd_feature",referencedColumnName="ci_feature")
	private Map<Feature,MaterialQualify> features;
	
	@ManyToMany
	@JoinTable(name="tb_material_dimension_horizontal", schema="material",
				inverseJoinColumns={@JoinColumn(name = "cd_qualify", referencedColumnName = "ci_qualify")},
				joinColumns={@JoinColumn(name="cd_material",referencedColumnName="ci_material")})
	@OrderColumn(name="nr_order")
	private List<Qualify> horizontal;
	
	@ManyToMany
	@JoinTable(name="tb_material_dimension_vertical", schema="material",
				inverseJoinColumns={@JoinColumn(name = "cd_qualify", referencedColumnName = "ci_qualify")},
				joinColumns={@JoinColumn(name="cd_material",referencedColumnName="ci_material")})
	@OrderColumn(name="nr_order")
	private List<Qualify> vertical;
	
	@OneToOne(mappedBy="material")
	private Fiscal fiscal;
	
	@ElementCollection
    @CollectionTable(name="tb_material_specification",schema="material",
                     joinColumns=@JoinColumn(name="cd_material",referencedColumnName="ci_material"))
    @Column(name="ds_specification")
	@MapKeyJoinColumn(name="cd_specification",referencedColumnName="ci_specification")
	private Map<Specification,String> specifications;

	@OneToMany(mappedBy="material")
	private List<MaterialGrid> grid;

	/**
	 * Adiciona característica selecionada pelo usuário
	 * Irá armazenar os qualificadores desta característica
	 * 
	 * @param item
	 */
	public void addFeatureSelected(Feature feature, List<Qualify> qualifies,String complement) {
		switch(feature.getGridType()){
			case HORIZONTAL:
				this.horizontal = qualifies;
				return;
			case VERTICAL :
				this.vertical = qualifies;
				return;
			default:
				break;
		}
		
		switch(feature.getFeatureType()){
			case EXCLUSIVE:
				if(qualifies.size() > 1){
					throw new RuntimeException(String.format("Característica %s permite informar apenas um qualificador!",feature.getName()));
				}
				if(qualifies.isEmpty() && feature.getRequired()){
					throw new RuntimeException(String.format("Característica %s é obrigatória!",feature.getName()));
				}
				break;
			case ADDITIONAL:				
				if(qualifies.isEmpty() && feature.getRequired()){
					throw new RuntimeException(String.format("Característica %s é obrigatória!",feature.getName()));
				}
				break;
			case DESCRIPTIVE:				
				if((complement == null || complement.isEmpty()) && feature.getRequired()){
					throw new RuntimeException(String.format("Característica %s é obrigatória!",feature.getName()));
				}
				break;
			default:
				break;
		}
		
		MaterialQualify qualify = MaterialQualify.builder()
				.material(this.id)
				.qualify(qualifies)
				.complement(complement)
				.build();

		this.features.put(feature, qualify);
	}
	
	public boolean isValid(){
		
		for(Feature f : this.category.getFeatures()){
			
			switch(f.getGridType()){
				case HORIZONTAL:
					if(this.horizontal == null){
						return false;
					}					
					break;
				case VERTICAL:
					if(this.vertical == null){
						return false;
					}
					break;
				default:
					if(f.getRequired()){
						MaterialQualify qualify = this.features.get(f);
						if(qualify == null){
							return false;
						}
					}	
			}
				
		}
		
		return true;
	}

}