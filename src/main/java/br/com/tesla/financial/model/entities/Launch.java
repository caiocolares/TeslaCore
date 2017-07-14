package br.com.tesla.financial.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.tesla.auth.model.entities.User;
import br.com.tesla.core.model.entities.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
DEBIT - Contas a Pagar
	workgroup	Workgroup - Empresa
	stakeholder	Provider - Fornecedor	
		
CREDIT - Contas a Receber
	workgroup	Workgroup - Empresa
	stakeholder	Customer - Cliente
	
TRANSFER - Transferência
	workgroup	Workgroup - Empresa
	stakeholder	Workgroup - Empresa
	
 * @author caio
 *
 */

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_launch", schema = "financial" 
       //,uniqueConstraints = {@UniqueConstraint(columnNames = { "fl_type", "cd_workgroup", "cd_document", "nr_document", "nr_parcel" }) }
		)
public class Launch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ci_launch")
	private Integer id;

	@Column(name = "fl_type", length = 10)
	@Enumerated(EnumType.STRING)
	private LaunchType type;

	@OneToOne
	@JoinColumn(name = "cd_workgroup", referencedColumnName = "ci_person")
	private Person workgroup;

	@OneToOne
	@JoinColumn(name = "cd_stakeholder", referencedColumnName = "ci_person")
	private Person stakeholder;
	
	@ManyToOne
	@JoinColumn(name="cd_account",referencedColumnName="ci_account")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="cd_user",referencedColumnName="ci_user")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_document", referencedColumnName = "ci_launch_document")
	private LaunchDocument document;
	
	@Column(name = "nr_document", length = 50)
	private String documentNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_document_origin", referencedColumnName = "ci_launch_document_origin")
	private LaunchDocumentOrigin documentOrigin;
	
	@Column(name="nr_document_origin", length = 50)
	private String documentOriginNumber;
		
	@Column(name = "nr_parcel")
	private Integer parcel;

	@Column(name = "nr_parcel_total")
	private Integer parcelTotal;

	@Column(name = "nr_amount")
	private BigDecimal amount;

	@Column(name = "nr_amount_total")
	private BigDecimal amountTotal;

	@Column(name = "dt_emission")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEmission;

	@Column(name = "dt_pay")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePay;

	@Column(name = "dt_launch")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLaunch;
	
	@Column(name="ds_observation")	
	private String observation;
	
	@OneToMany(mappedBy="launch",cascade=CascadeType.ALL)
	private List<LaunchPayment> payments;
	
	@Column(name="fl_status")
	@Enumerated(EnumType.STRING)
	private LaunchStatus launchStatus = LaunchStatus.ABERTO;
	
	@OneToMany(mappedBy="launch", cascade=CascadeType.ALL)
	private List<Receivable> receivables;
	
	@Transient
	private BigDecimal associated;
	
	@Transient
	private BigDecimal payed;

	public BigDecimal getPayed(){
		if(payed == null){
			if(this.payments == null){
				payed = BigDecimal.ZERO;
			}else{
				payed = this.payments.stream().
								map(p -> p.getPaymentAmount()).
								reduce(BigDecimal.ZERO,BigDecimal::add);
			}
		}
		return this.payed;
	}
	
	public BigDecimal getAssociated(){
		if(associated == null){
			if(this.receivables == null){
				associated = BigDecimal.ZERO;
			}else{
				associated = this.receivables.stream().
							 	filter(r -> r.getStatus().equals(ReceivableStatus.ABERTO)).
							 	map(r -> r.getAmount()).
							 	reduce(BigDecimal.ZERO,BigDecimal::add);
			}
		}
		return this.associated;
	}
	
	public BigDecimal getBalance(){
		return getAmount().add(getAssociated().add(getPayed()).multiply(new BigDecimal(-1)));
	}
	
	public boolean addReceivable(Receivable receivable){
		if(receivable.getAmount().add(getAssociated()).add(getPayed()).compareTo(this.amount) == 1){
			return false;
		}
		return this.receivables.add(receivable);	
	}
	
	public boolean addPayment(LaunchPayment payment){
		if(payment.getPaymentAmount().add(getAssociated()).add(getPayed()).compareTo(this.amount) == 1){
			return false;
		}
		return this.payments.add(payment);	
	}
	
}