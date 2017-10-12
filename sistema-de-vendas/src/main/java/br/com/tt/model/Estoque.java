package br.com.tt.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Estoque {

	@Id
	@SequenceGenerator(name = "estoque_seq", sequenceName = "estoque_seq", allocationSize = 1)
	@GeneratedValue(generator = "estoque_seq", strategy = GenerationType.AUTO)

	@Column(name = "id_estoque", nullable = false)
	private Long id;

	@Column(name = "nome_produto", length = 45, nullable = false)
	private String nome;

	@Column(name = "valor_produto_un", length = 20, nullable = false)
	private Double vl_unit;

	@Column(name = "valor_total", length = 20, nullable = false)
	private Double vl_total;

	@Column(name = "data_entrada", length = 30, nullable = false)
	private Date dt_ent;

	@Column(name = "quantidade", length = 10, nullable = false)
	private Double qtd;

	@Column(name = "cnpj_fornecedor", nullable = false, length = 14)
	private String cnpj;

	@Column(name = "nota_fiscal", length = 45)
	private String nf;

	@OneToOne(cascade = { CascadeType.ALL })
	private Produto produto;

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

	public Date getDt_ent() {
		return dt_ent;
	}

	public void setDt_ent(Date dt_ent) {
		this.dt_ent = dt_ent;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
