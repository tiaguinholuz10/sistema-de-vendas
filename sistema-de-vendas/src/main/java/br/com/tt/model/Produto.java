package br.com.tt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto {

	@Id
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
	@GeneratedValue(generator = "produto_seq", strategy = GenerationType.AUTO)

	@Column(name = "codigo_produto", nullable = false, unique = true)
	private Long id;

	@Column(name = "nome_produto", length = 45, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 120)
	private String descricao;
	
	@Column(name = "cnpj_fornecedor", length = 120)
	private String cnpj;	

	@Column(name = "tipo_de_unidade", length = 45, nullable = false)
	private String unid;

	@Column(name = "saldo_estoque", length = 12)
	private Double saldo;

	@OneToOne(mappedBy = "produto", cascade = { CascadeType.ALL })
	private Estoque estoque;

	@ManyToMany
	@JoinTable(name="produto_fornecedor", joinColumns={@JoinColumn(name="produto_id")}, inverseJoinColumns={@JoinColumn(name="fornecedor_id")})
	private List<Fornecedor> fornecedor;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}



}
