package br.com.tesla.manufacture.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "tb_flow", schema = "manufacture")
public class Flow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_flow")
	private Integer id;

	@Column(name = "nm_flow")
	private String name;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "cd_flow", referencedColumnName = "ci_flow")
	@OrderBy(value="nr_order") 
	private List<FlowProcess> processes = new ArrayList<FlowProcess>(0);

	public void addProcess(Process item) {
		int order = processes.size()+1;
		FlowProcess flowProcess = FlowProcess.builder().flow(this).process(item).order(order).build();
		this.processes.add(flowProcess);
	}

}