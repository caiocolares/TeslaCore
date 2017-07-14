package br.com.tesla.core.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PRIVATE)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Data
@Builder
@Entity
@Table(name = "tb_identifier", schema = "core")
public class Identifier {

	@Id
	@Column(name = "ci_identifier", length = 50)
	private String id;

	@Column(name = "ds_text_fir")
	@Type(type = "text")
	private String textFir;

	@Column(name = "bl_photo")
	@JsonSerialize(using = br.com.tesla.json.ByteArraySerializer.class)
	private byte[] photo;

	@Column(name = "bl_finger")
	@JsonSerialize(using = br.com.tesla.json.ByteArraySerializer.class)
	private byte[] finger;

	@Column(name = "fl_enabled")
	private Boolean enabled;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ci_identifier", referencedColumnName = "ci_person")
	private Person person;

}