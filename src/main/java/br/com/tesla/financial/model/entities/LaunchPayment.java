package br.com.tesla.financial.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.tesla.auth.model.entities.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access=AccessLevel.PACKAGE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)

@Data
@Entity
@Table(name="tb_launch_payment", schema="financial")
public class LaunchPayment {

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_launch_payment")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cd_launch",referencedColumnName="ci_launch")
	private Launch launch;
	
	@Column(name="dt_payment")
	private Date paymentDate;
	
	@Column(name="nr_amount")
	private BigDecimal paymentAmount;
	
	@Column(name="ds_observation")	
	private String observation;
	
	@Column(name="nr_discount")
	private BigDecimal discount;
	
	@Column(name="nr_interest")
	private BigDecimal interest;
	
	@ManyToOne
	@JoinColumn(name="cd_user",referencedColumnName="ci_user")
	private User user;

	//Account
	
}
