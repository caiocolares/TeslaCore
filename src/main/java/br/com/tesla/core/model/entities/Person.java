package br.com.tesla.core.model.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.bean.validation.CPF;
import br.com.tesla.auth.model.entities.User;
import br.com.tesla.json.DateDeserializer;
import br.com.tesla.json.DateSerializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "tb_person", schema = "core")
public class Person {

	@Id
	@Column(name = "ci_person", length = 50)
	private String id;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_type", length = 12)
	private PersonType personType;

	@Column(name = "ci_code_erp")
	private BigInteger codeErp;

	@Size(min = 10, message = "Nome deve possuir no mínimo 10 caracteres")
	@Column(name = "nm_person", length = 200)
	private String name;
	
	@Column(name = "nm_fantasy", length = 200)
	private String fantasy;

	@CNPJ
	@Column(name = "nr_cnpj", length = 20)
	private String cnpj;

	@Column(name = "nr_ie", length = 20)
	private String ie;

	@CPF
	@Column(name = "nr_cpf", length = 20)
	private String cpf;

	@Column(name = "nr_rg", length = 20)
	private String rg;
	
	@NotNull(message = "Data de Nascimento não pode ser vazia")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_birth")
	private Date birth;

	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_update")
	private Date lastUpdate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_city", referencedColumnName = "ci_city")
	private City city;

	@Column(name = "ds_email")
	private String email;

	@Column(name = "ds_site")
	private String site;

	@Column(name = "ds_twitter")
	private String twitter;

	@Column(name = "ds_facebook")
	private String facebook;

	@Column(name = "ds_photo")
	@Type(type = "text")
	private String photo;

	@Enumerated(EnumType.STRING)
	@Column(name = "fl_gender")
	private PersonGender gender = PersonGender.MASCULINO;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cd_person", referencedColumnName = "ci_person")
	private List<Address> address;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cd_person", referencedColumnName = "ci_person")
	private List<Phone> phones;

	@OneToOne(mappedBy = "person", optional = true)
	private Customer customer;

	@OneToOne(mappedBy = "person", optional = true)
	private User user;

	@OneToOne(mappedBy = "person", optional = true)
	private Employee employee;

	@OneToOne(mappedBy = "person", optional = true)
	private Provider provider;
	
	@OneToOne(mappedBy = "person", optional = true)
	private WorkGroup workgroup;

	@OneToOne(mappedBy = "person", optional = true)
	private Broker broker;

	public void setId(String id) {

		this.id = id;

		if (customer != null)
			customer.setId(this.id);
		if (user != null)
			user.setId(this.id);
		if (employee != null)
			employee.setId(this.id);
		if (provider != null)
			provider.setId(this.id);
		if (workgroup != null)
			workgroup.setId(this.id);
		if (broker != null)
			broker.setId(this.id);
	}

}