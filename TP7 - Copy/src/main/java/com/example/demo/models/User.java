package com.example.demo.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class User {
	User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idUser;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "PASS")
	private String pass;
	@Column(name = "EMAIL")
	private String mail;
	@Column(name = "VILLE")
	private String ville;

	public User(String login, String pass, String mail, String ville) {
		super();

		this.login = login;
		this.pass = pass;
		this.mail = mail;
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
}
