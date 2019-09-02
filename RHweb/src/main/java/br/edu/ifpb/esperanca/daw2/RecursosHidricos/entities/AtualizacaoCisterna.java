package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class AtualizacaoCisterna implements Identificavel {

	@Id
	@GeneratedValue(generator= "atualizacao",  strategy=GenerationType.SEQUENCE)
	@SequenceGenerator (name="atualizacao")
	private Long id;
	private Date periodoAguaAtualizada;

	@ManyToOne
	private Cisterna cisterna;
	
	@ManyToOne
	private AtualizacaoCisterna quantLitrosAgua;
	

	public Long getId() {
		return id;
	}

	public void setId(Long idAtualizacao) {
		this.id = idAtualizacao;
	}

	public Date getPeriodoAguaAtualizada() {
		return periodoAguaAtualizada;
	}

	public void setPeriodoAguaAtualizada(Date periodoAguaAtualizada) {
		this.periodoAguaAtualizada = periodoAguaAtualizada;
	}

	public Cisterna getCisterna() {
		return cisterna;
	}

	public void setCisterna(Cisterna cisterna) {
		this.cisterna = cisterna;
	}

	public AtualizacaoCisterna getQuantLitrosAgua() {
		return quantLitrosAgua;
	}

	public void setQuantLitrosAgua(AtualizacaoCisterna quantLitrosAgua) {
		this.quantLitrosAgua = quantLitrosAgua;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cisterna == null) ? 0 : cisterna.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((periodoAguaAtualizada == null) ? 0 : periodoAguaAtualizada.hashCode());
		result = prime * result + ((quantLitrosAgua == null) ? 0 : quantLitrosAgua.hashCode());
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
		AtualizacaoCisterna other = (AtualizacaoCisterna) obj;
		if (cisterna == null) {
			if (other.cisterna != null)
				return false;
		} else if (!cisterna.equals(other.cisterna))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (periodoAguaAtualizada == null) {
			if (other.periodoAguaAtualizada != null)
				return false;
		} else if (!periodoAguaAtualizada.equals(other.periodoAguaAtualizada))
			return false;
		if (quantLitrosAgua == null) {
			if (other.quantLitrosAgua != null)
				return false;
		} else if (!quantLitrosAgua.equals(other.quantLitrosAgua))
			return false;
		return true;
	}

}