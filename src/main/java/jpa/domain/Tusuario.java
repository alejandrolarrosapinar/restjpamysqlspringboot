package jpa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tusuarios database table.
 * 
 */
@Entity
@Table(name="tusuarios")
@NamedQuery(name="Tusuario.findAll", query="SELECT t FROM Tusuario t")
public class Tusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String login;

	private String pass;

	public Tusuario() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}