package br.com.tesla.financial.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tesla.auth.model.entities.User;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Receivable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ci_receivable")
	protected Integer id;
	
	@Column(name="fl_receivable_type")
	@Enumerated(EnumType.STRING)
	protected ReceivableType receivableType;

	@Column(name="nr_amount")
	protected BigDecimal amount;
	
	@Column(name="dt_launch")
	@Temporal(TemporalType.DATE)
	protected Date launchDate;
	
	@Column(name="dt_pay")
	@Temporal(TemporalType.DATE)
	protected Date payDate;
	
	@Column(name="fl_receivable_status")
	@Enumerated(EnumType.STRING)
	protected ReceivableStatus status = ReceivableStatus.ABERTO;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cd_launch",referencedColumnName="ci_launch")
	protected Launch launch;
	
	@JsonIgnore
	@ManyToOne(optional=true,cascade=CascadeType.ALL)
	@JoinColumn(name="cd_launch_payment",referencedColumnName="ci_launch_payment")
	protected LaunchPayment payment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ReceivableType getReceivableType() {
		return receivableType;
	}

	public void setReceivableType(ReceivableType receivableType) {
		this.receivableType = receivableType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Launch getLaunch() {
		return launch;
	}

	public void setLaunch(Launch launch) {
		this.launch = launch;
	}

	public ReceivableStatus getStatus() {
		return status;
	}

	public void setStatus(ReceivableStatus status) {
		
		if(status.equals(ReceivableStatus.BAIXADO)){			
			this.payment = LaunchPayment.builder()
										.paymentAmount(amount)
										.launch(launch)
										.paymentDate(new Date()).build();				
			this.launch.addPayment(payment);
		}
		
		this.status = status;
	}
	public void setStatus(ReceivableStatus status, User user) {
		
		if(status.equals(ReceivableStatus.BAIXADO)){			
			this.payment = LaunchPayment.builder()
					.paymentAmount(amount)
					.launch(launch)
					.user(user)
					.paymentDate(new Date()).build();				
			this.launch.addPayment(payment);
		}
		
		this.status = status;
	}
	
}
