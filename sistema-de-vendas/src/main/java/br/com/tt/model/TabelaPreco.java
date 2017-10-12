package br.com.tt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_preco")
public class TabelaPreco {

	@Id
	@SequenceGenerator(name = "tbpreco_seq", sequenceName = "tbpreco_seq", allocationSize = 1)
	@GeneratedValue(generator = "tbpreco_seq", strategy = GenerationType.AUTO)

	@Column(name = "id_tbPreco")
	private Long id;

	@Column(name = "codigo_produto", length = 12, nullable = false)
	private String cod_produto;

	@Column(name = "Valor_unitario")
	private Double tb_unit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}

	public Double getTb_unit() {
		return tb_unit;
	}

	public void setTb_unit(Double tb_unit) {
		this.tb_unit = tb_unit;
	}

}
