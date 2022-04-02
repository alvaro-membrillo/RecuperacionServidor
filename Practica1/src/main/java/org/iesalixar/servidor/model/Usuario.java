package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String usuario;
	private String email;
	private String password;
	private String role;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String usuario, String email, String password, String role) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
