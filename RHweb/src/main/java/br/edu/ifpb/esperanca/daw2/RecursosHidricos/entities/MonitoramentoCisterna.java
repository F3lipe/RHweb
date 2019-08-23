package br.edu.ifpb.esperanca.daw2.RecursosHidricos.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MonitoramentoCisterna implements Identificavel {

	@Id
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date monitoramentoInicial;
	private Date monitoramentoFinal;

	private Double quantAguaGastaTempo;

	@OneToMany(mappedBy = "quantLitrosAgua")
	private Set<AtualizacaoCisterna> aguaGasta;

	
	

	public MonitoramentoCisterna() {
		super();
	}


	public Long getId() {
		return id;
	}


	public Date getMonitoramentoInicial() {
		return monitoramentoInicial;
	}


	public void setMonitoramentoInicial(Date monitoramentoInicial) {
		this.monitoramentoInicial = monitoramentoInicial;
	}


	public Date getMonitoramentoFinal() {
		return monitoramentoFinal;
	}


	public void setMonitoramentoFinal(Date monitoramentoFinal) {
		this.monitoramentoFinal = monitoramentoFinal;
	}


	public Double getQuantAguaGastaTempo() {
		return quantAguaGastaTempo;
	}


	public void setQuantAguaGastaTempo(Double quantAguaGastaTempo) {
		this.quantAguaGastaTempo = quantAguaGastaTempo;
	}


	public Set<AtualizacaoCisterna> getAguaGasta() {
		return aguaGasta;
	}


	public void setAguaGasta(Set<AtualizacaoCisterna> aguaGasta) {
		this.aguaGasta = aguaGasta;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aguaGasta == null) ? 0 : aguaGasta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monitoramentoFinal == null) ? 0 : monitoramentoFinal.hashCode());
		result = prime * result + ((monitoramentoInicial == null) ? 0 : monitoramentoInicial.hashCode());
		result = prime * result + ((quantAguaGastaTempo == null) ? 0 : quantAguaGastaTempo.hashCode());
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
		MonitoramentoCisterna other = (MonitoramentoCisterna) obj;
		if (aguaGasta == null) {
			if (other.aguaGasta != null)
				return false;
		} else if (!aguaGasta.equals(other.aguaGasta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (monitoramentoFinal == null) {
			if (other.monitoramentoFinal != null)
				return false;
		} else if (!monitoramentoFinal.equals(other.monitoramentoFinal))
			return false;
		if (monitoramentoInicial == null) {
			if (other.monitoramentoInicial != null)
				return false;
		} else if (!monitoramentoInicial.equals(other.monitoramentoInicial))
			return false;
		if (quantAguaGastaTempo == null) {
			if (other.quantAguaGastaTempo != null)
				return false;
		} else if (!quantAguaGastaTempo.equals(other.quantAguaGastaTempo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MonitoramentoCisterna [id=" + id + ", monitoramentoInicial=" + monitoramentoInicial
				+ ", monitoramentoFinal=" + monitoramentoFinal + ", quantAguaGastaTempo=" + quantAguaGastaTempo
				+ ", aguaGasta=" + aguaGasta + "]";
	}

	

}