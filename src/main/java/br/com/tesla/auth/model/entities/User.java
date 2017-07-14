package br.com.tesla.auth.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tesla.core.model.entities.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_user", schema = "core")
public class User implements UserDetails {

	private static final long serialVersionUID = -7414463823912132283L;

	@Id
	@Column(name = "ci_user", length = 50)
	private String id;

	@NotNull
	@Column(name = "ds_login", length = 50, unique = true)
	private String login;

	@Column(name = "ds_password", length = 50)
	private String password;

	@Column(name = "fl_active")
	private Boolean active = false;

	@Column(name = "fl_enabled")
	private Boolean enabled = false;

	@Column(name = "dt_access")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastAccess;

	@Column(name = "fl_update_password")
	private Boolean passwordUpdated = false;

	@Column(name = "fl_premium")
	private Boolean premium = false;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ci_user", referencedColumnName = "ci_person", updatable = false, insertable = false)
	private Person person;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_user_group", schema = "core", joinColumns = {
			@JoinColumn(name = "cd_user", referencedColumnName = "ci_user", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "cd_group", referencedColumnName = "ci_group", nullable = false) })
	private List<Group> groups;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_user_transaction", schema = "core", joinColumns = {
			@JoinColumn(name = "cd_user", referencedColumnName = "ci_user") }, inverseJoinColumns = {
					@JoinColumn(name = "cd_transaction", referencedColumnName = "ci_transaction") })
	private List<Transaction> userTransactions;

	@JsonIgnore
	@Transient
	private Set<SimpleGrantedAuthority> authorities;

	public String generateNewPassword() {
		char[] chart = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
				'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
				'Z' };
		char[] senha = new char[6];

		Random rdm = new Random();

		for (int x = 0; x < 6; x++) {
			senha[x] = chart[rdm.nextInt(chart.length)];
		}
		String password = new String(senha);

		this.password = new Md5PasswordEncoder().encodePassword(password, null);

		return password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@JsonIgnore
	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		if(authorities == null){
			authorities = new HashSet<>();
			
			if(userTransactions == null)
				userTransactions = new ArrayList<>();
				
			userTransactions.forEach(t -> authorities.add( new SimpleGrantedAuthority("ROLE_"+t.getLabel())));
			
			if(groups == null)
				groups = new ArrayList<>();
			
			groups.stream().map(g -> g.getTransactions()).flatMap(List::stream).forEach(s -> authorities.add(new SimpleGrantedAuthority("ROLE_"+s.getLabel())));					
		}
		return authorities;
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return this.login;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return this.enabled != null && this.enabled;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Boolean getPasswordUpdated() {
		return passwordUpdated;
	}

	public void setPasswordUpdated(Boolean passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}