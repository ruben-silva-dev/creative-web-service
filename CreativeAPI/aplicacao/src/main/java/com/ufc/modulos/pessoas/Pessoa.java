package com.ufc.modulos.pessoas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonView;
import com.ufc.util.json.View;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

	@Id
	@TableGenerator(name = "pessoa_id", table = "pessoa_id", pkColumnName = "pos", pkColumnValue = "val", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pessoa_id")
	@JsonView({ View.Pessoa.class, View.Avaliacao.class, View.Comentario.class })
	private Long id;

	@JsonView(View.Pessoa.class)
	private String nome;

	@JsonView(View.Pessoa.class)
	private String email;

	private String senha;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
