package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cultivo implements Identificavel {

	@Id
	private Long id;
	private String nomeCultivo;
	private String descricao;
	private Date periodoSafra;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getNomeCultivo() {
		return nomeCultivo;

	}

	public void setNomeCultivo(String nomeCultivo) {
		this.nomeCultivo = nomeCultivo;
	}

		public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

		public Date getPeriodoSafra() {
		return periodoSafra;
	}

	public void setPeriodoSafra(Date periodoSafra) {
		this.periodoSafra = periodoSafra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nomeCultivo == null) ? 0 : nomeCultivo.hashCode());
		result = prime * result + ((periodoSafra == null) ? 0 : periodoSafra.hashCode());
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
		Cultivo other = (Cultivo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nomeCultivo == null) {
			if (other.nomeCultivo != null)
				return false;
		} else if (!nomeCultivo.equals(other.nomeCultivo))
			return false;
		if (periodoSafra == null) {
			if (other.periodoSafra != null)
				return false;
		} else if (!periodoSafra.equals(other.periodoSafra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cultivo [nomeCultivo=" + nomeCultivo + ", descri��o=" + descricao + ", periodoSafra=" + periodoSafra
				+ "]";
	}

	public Cultivo() {
		super();
		
	}

}
