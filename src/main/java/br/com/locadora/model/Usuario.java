/**
 * 
 */
package br.com.locadora.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * @author cbarbosag
 *
 */
@Entity
@Data
public class Usuario implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 200)
	@NotBlank(message = "Nome é informação obrigatória.")
	private String nome;

	@Column(nullable = false, length = 200)
	@NotBlank(message = "Login é informação obrigatória.")
	private String login;

	@Column(nullable = false, length = 200)
	@NotBlank(message = "E-mail é informação obrigatória.")
	private String email;

	@Column(nullable = false, length = 225)
	@NotBlank(message = "Senha é informação obrigatória.")
	private String senha;

	@ManyToMany
	private List<Grupo> grupos;

	@Column(nullable = false)
	private boolean ativo = false;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	


}
