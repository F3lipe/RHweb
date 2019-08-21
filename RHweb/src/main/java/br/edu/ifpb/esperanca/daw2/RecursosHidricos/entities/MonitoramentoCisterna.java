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
	private Date monitoramento;

	private Double quantAguaGastaTempo;
	private Double quantAguaEconomizadaTempo;

	@OneToMany(mappedBy = "quantLitrosAgua")
	private Set<AtualizacaoCisterna> aguaGasta;

	@OneToMany(mappedBy = "quantLitrosAgua")
	private Set<AtualizacaoCisterna> aguaEconomizada;

	public Long getId() {
		return id;
	}

	public void setId(Long idMonitoramento) {
		this.id = idMonitoramento;
	}

	public Date getMonitoramento() {
		return monitoramento;
	}

	public void setMonitoramento(Date monitoramento) {
		this.monitoramento = monitoramento;
	}

	public Double getQuantAguaGastaTempo() {
		return quantAguaGastaTempo;
	}

	public void setQuantAguaGastaTempo(Double quantAguaGastaTempo) {
		this.quantAguaGastaTempo = quantAguaGastaTempo;
	}

	public Double getQuantAguaEconomizadaTempo() {
		return quantAguaEconomizadaTempo;
	}

	public void setQuantAguaEconomizadaTempo(Double quantAguaEconomizadaTempo) {
		this.quantAguaEconomizadaTempo = quantAguaEconomizadaTempo;
	}

	public Set<AtualizacaoCisterna> getAguaGasta() {
		return aguaGasta;
	}

	public void setAguaGasta(Set<AtualizacaoCisterna> aguaGasta) {
		this.aguaGasta = aguaGasta;
	}

	public Set<AtualizacaoCisterna> getAguaEconomizada() {
		return aguaEconomizada;
	}

	public void setAguaEconomizada(Set<AtualizacaoCisterna> aguaEconomizada) {
		this.aguaEconomizada = aguaEconomizada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aguaEconomizada == null) ? 0 : aguaEconomizada.hashCode());
		result = prime * result + ((aguaGasta == null) ? 0 : aguaGasta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((monitoramento == null) ? 0 : monitoramento.hashCode());
		result = prime * result + ((quantAguaEconomizadaTempo == null) ? 0 : quantAguaEconomizadaTempo.hashCode());
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
		if (aguaEconomizada == null) {
			if (other.aguaEconomizada != null)
				return false;
		} else if (!aguaEconomizada.equals(other.aguaEconomizada))
			return false;
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
		if (monitoramento == null) {
			if (other.monitoramento != null)
				return false;
		} else if (!monitoramento.equals(other.monitoramento))
			return false;
		if (quantAguaEconomizadaTempo == null) {
			if (other.quantAguaEconomizadaTempo != null)
				return false;
		} else if (!quantAguaEconomizadaTempo.equals(other.quantAguaEconomizadaTempo))
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
		return "MonitoramentoCisterna [idMonitoramento=" + id + ", monitoramento=" + monitoramento
				+ ", quantAguaGastaTempo=" + quantAguaGastaTempo + ", quantAguaEconomizadaTempo="
				+ quantAguaEconomizadaTempo + ", aguaGasta=" + aguaGasta + ", aguaEconomizada=" + aguaEconomizada + "]";
	}

}