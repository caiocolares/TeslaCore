package br.com.tesla.bank.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name="tb_parcel",schema="bank")
public class Parcel {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ci_parcel")
	private Integer id;
	
	@Column(name="nr_subsidiary")
	private Integer subsidiary;
	
	@Column(name="nr_credit_card_number")
	private String creditCardNumber;
	@Column(name="fl_credit_card_flag")
	private Integer creditCardFlag;
	
	@Column(name="nr_nsu")
	private String nsu;
	@Column(name="nr_terminal")
	private String terminal;
	@Column(name="nr_authorization")
	private String authorization;
	
	@Column(name="nr_transacrion_uid")
	private String transactionUid;
	
	@Column(name="nr_amount")
	private BigDecimal amount;
	@Column(name="nr_balance_amount")
	private BigDecimal balanceAmount;

	@Column(name="dt_sale")
	@Temporal(TemporalType.DATE)
	private Date saleDate;
	@Column(name="dt_pay")
	@Temporal(TemporalType.DATE)
	private Date payDate;
	
	@Column(name="nr_administration_amount")
	private BigDecimal administrationAmount;
	@Column(name="nr_administration_tax")
	private BigDecimal administrationTax;
	
	@Column(name="nr_antecipation_amount")
	private BigDecimal atencipationAmount;
	@Column(name="nr_antecipation_tax")
	private BigDecimal atencipationTax;
	@Column(name="dt_antecipation")
	@Temporal(TemporalType.DATE)
	private Date antecipationDade;
	
	@Column(name="nr_parcel")
	private Integer parcelNumber;
	@Column(name="nr_parcel_count")
	private Integer parcelCount;
	
	@Column(name="nr_invoice")
	private Integer invoice;
	
	@Column(name="dt_transaction_time")
	private String transactionTime;
	
}
