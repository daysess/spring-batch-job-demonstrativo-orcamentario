package br.com.daysesoares.demonstrativoorcamentario.dominio;

import java.util.Date;

public class Lancamento {
	
	private Integer codigoNaturezaDespesa;
	private String descricaoNaturezaDespesa;
	private String descricaoLancamento;
	private Date dataLancamento;
	private Double valorLancamento;
	
	public Lancamento () {
		
	}

	public Integer getCodigoNaturezaDespesa() {
		return codigoNaturezaDespesa;
	}

	public void setCodigoNaturezaDespesa(Integer codigoNaturezaDespesa) {
		this.codigoNaturezaDespesa = codigoNaturezaDespesa;
	}

	public String getDescricaoNaturezaDespesa() {
		return descricaoNaturezaDespesa;
	}

	public void setDescricaoNaturezaDespesa(String descricaoNaturezaDespesa) {
		this.descricaoNaturezaDespesa = descricaoNaturezaDespesa;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	@Override
	public String toString() {
		return "Lancamento [codigoNaturezaDespesa=" + codigoNaturezaDespesa + ", descricaoNaturezaDespesa="
				+ descricaoNaturezaDespesa + ", descricaoLancamento=" + descricaoLancamento + ", dataLancamento="
				+ dataLancamento + ", valorLancamento=" + valorLancamento + "]";
	}

	

}
