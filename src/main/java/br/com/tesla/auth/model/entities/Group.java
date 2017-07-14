package br.com.tesla.auth.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
@Table(name = "tb_group", schema = "core")
public class Group  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_group")
	private Integer id;

	@Size(min=4, max=50, message="Grupo não pode ter menos que 4 caracteres")
	@Column(name = "nm_group", length = 50)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tb_group_transaction",schema="core", 
			joinColumns={@JoinColumn(name="cd_group",referencedColumnName="ci_group")},
				inverseJoinColumns={@JoinColumn(name="cd_transaction",referencedColumnName="ci_transaction")})
	private List<Transaction> transactions;

}