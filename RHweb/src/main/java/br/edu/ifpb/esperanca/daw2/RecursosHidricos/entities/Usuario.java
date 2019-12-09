package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Identificavel {

	@Id
	@GeneratedValue(generator = "usu_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "usu_seq")
	private Long id;
	private String nome;
	private String cidade;
	private int numeroTelefone;
	private String email;
	private String senha;
	private String estado;

	@Lob
	@Column(name = "imageUser")
	private byte[] imageUser;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String cidade, int numeroTelefone, String email, String senha, String estado,
			byte[] imageUser) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.senha = senha;
		this.estado = estado;
		this.imageUser = imageUser;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public byte[] getImageUser() {
		return imageUser;
	}

	public void setImageUser(byte[] imageUser) {
		this.imageUser = imageUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(imageUser);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroTelefone;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(imageUser, other.imageUser))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroTelefone != other.numeroTelefone)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", numeroTelefone=" + numeroTelefone
				+ ", email=" + email + ", senha=" + senha + ", estado=" + estado + ", imageuser=" + imageUser + "]";
	}

}
