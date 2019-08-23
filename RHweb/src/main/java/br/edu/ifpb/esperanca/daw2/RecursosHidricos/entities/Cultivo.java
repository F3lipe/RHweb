package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cultivo implements Identificavel {

	@Id
	private Long id;
	private String nomeCultivo;
	private String descri��o;
	private Date periodoSafra;

	@Override
	public Long getId() {

		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public String getNomeCultivo() {
		return nomeCultivo;

	}

	public void setNomeCultivo(String nomeCultivo) {
		this.nomeCultivo = nomeCultivo;
	}

	public String getDescri��o() {
		return descri��o;
	}

	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
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
		result = prime * result + ((descri��o == null) ? 0 : descri��o.hashCode());
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
		if (descri��o == null) {
			if (other.descri��o != null)
				return false;
		} else if (!descri��o.equals(other.descri��o))
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
		return "Cultivo [nomeCultivo=" + nomeCultivo + ", descri��o=" + descri��o + ", periodoSafra=" + periodoSafra
				+ "]";
	}

	public Cultivo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
