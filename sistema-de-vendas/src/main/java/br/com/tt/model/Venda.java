package br.com.tt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Venda {

	@Id
	@SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", allocationSize = 1)
	@GeneratedValue(generator = "venda_seq", strategy = GenerationType.AUTO)

	@Column(name = "id_venda")
	private Long id;

	@Column(name = "quantidade")
	private String quant;

	@Column(name = "data_saida")
	private Date dt_venda;

	@Column(name = "valor_unitario")
	private Double vl_unit;

	@Column(name = "valor_total")
	private Double vl_total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuant() {
		return quant;
	}

	public void setQuant(String quant) {
		this.quant = quant;
	}

	public Date getDt_venda() {
		return dt_venda;
	}

	public void setDt_venda(Date dt_venda) {
		this.dt_venda = dt_venda;
	}

	public Double getVl_unit() {
		return vl_unit;
	}

	public void setVl_unit(Double vl_unit) {
		this.vl_unit = vl_unit;
	}

	public Double getVl_total() {
		return vl_total;
	}

	public void setVl_total(Double vl_total) {
		this.vl_total = vl_total;
	}

}
