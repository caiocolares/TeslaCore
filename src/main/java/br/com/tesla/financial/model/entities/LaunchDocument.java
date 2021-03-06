package br.com.tesla.financial.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_launch_document", schema = "financial")
public class LaunchDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_launch_document")
	private Integer id;

	@Column(name = "nm_launch_document", length = 40)
	private String name;
	
	@Column(name = "fl_launch_document", length = 20)
	@Enumerated(EnumType.STRING)
	private LaunchDocumentType type;
	
	@Column(name = "nr_current_value")
	private Integer currentValue;
	
	@Column(name = "fl_active")
	private Boolean active = false;		
	
}