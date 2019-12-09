package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Irrigacao implements Identificavel {

	@Id
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date diasDeIrrigacao;

	private Double umidade;

	private Double temperatura;

	public Double getUmidade() {
		return umidade;
	}

	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Irrigacao(Double umidade, Double temperatura) {
		super();
		this.umidade = umidade;
		this.temperatura = temperatura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getDiasDeIrrigacao() {
		return diasDeIrrigacao;
	}

	public void setDiasDeIrrigacao(Date diasDeIrrigacao) {
		this.diasDeIrrigacao = diasDeIrrigacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diasDeIrrigacao == null) ? 0 : diasDeIrrigacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((temperatura == null) ? 0 : temperatura.hashCode());
		result = prime * result + ((umidade == null) ? 0 : umidade.hashCode());
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
		Irrigacao other = (Irrigacao) obj;
		if (diasDeIrrigacao == null) {
			if (other.diasDeIrrigacao != null)
				return false;
		} else if (!diasDeIrrigacao.equals(other.diasDeIrrigacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (temperatura == null) {
			if (other.temperatura != null)
				return false;
		} else if (!temperatura.equals(other.temperatura))
			return false;
		if (umidade == null) {
			if (other.umidade != null)
				return false;
		} else if (!umidade.equals(other.umidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Irrigacao [id=" + id + ", tempoIrrigacao=" +  ", diasDeIrrigacao=" + diasDeIrrigacao
				+ ", umidade=" + umidade + ", temperatura=" + temperatura + "]";
	}

	public Irrigacao(Long id, Double tempoIrrigacao, Date diasDeIrrigacao) {
		super();
		this.id = id;
		this.diasDeIrrigacao = diasDeIrrigacao;
	}

	public Irrigacao() {
		super();

	}

}
