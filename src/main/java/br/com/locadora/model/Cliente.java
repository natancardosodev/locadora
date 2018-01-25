package br.com.locadora.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
/**
 * @author natancardosodev
 *
 */
@Entity
@Data
public class Cliente implements Serializable {

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
	@NotBlank(message = "E-mail é informação obrigatória.")
	private String email;

	@Column(nullable = false, length = 20)
	@NotBlank(message = "Telefone é informação obrigatória.")
	private Long telefone;
	
	@Column(nullable = false, length = 20)
	@NotBlank(message = "CPF é informação obrigatória.")
	private Long cpf;

	@ManyToMany
	private List<Grupo> grupos;

	@Column(nullable = false)
	private boolean ativo = false;
	
	public Cliente() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
