package com.licitacion.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 2396654715019746670L;

	private String id;
    private	String username;
	private String password;
	
	private Persona persona;
	
	@JsonCreator
	public Usuario(@JsonProperty("id") final String id, @JsonProperty("username") final String username,
			@JsonProperty("password") final String password) {
		super();
		this.id = requireNonNull(id);
		this.username = requireNonNull(username);
		this.password = requireNonNull(password);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
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

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
