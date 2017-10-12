package br.com.tt.bean.controlle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.dao.Dao;
import br.com.tt.dao.IDao;
import br.com.tt.model.Produto;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean {

	private Produto produto;
	private List<Produto> produtos;
	private IDao<Produto> dao;
	private String sql = "Select ";

	@PostConstruct
	private void init() {

		dao = new Dao<Produto>(Produto.class);
		produto = new Produto();
		produtos = new ArrayList<Produto>();
		produtos = dao.consultar();

	}

	public void salvar() {

		dao.salvar(produto);
		produtos = dao.consultar();
		MessageUtil.info("Produto Salvo", "Produto salvo com sucesso");
		produto = new Produto();

		/*
		 * System.out.println("Salvando \n\t" + cliente.getNome() + "\n\t" +
		 * cliente.getCpf()); MessageUtil.info("Salvo", cliente.getNome() +
		 * " Salvo com sucesso"); clientes.add(cliente); cliente = new
		 * Cliente();
		 */
	}

	public void cancelar() {
		MessageUtil.warn(" ", "O cadastro" + " foi cancelado!");
		produto = new Produto();
	}

	public void alterar(Produto produto) {
		this.produto = produto;

	}

	public void excluir() {
		MessageUtil.warn("", produto.getNome() + " Foi Excluido!");
		dao.excluir(produto.getId());
		produtos = dao.consultar();

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutos() {
		for (Produto produto : produtos) {
			System.out.println("Lista " + produto.getNome());

		}
		return produtos;
	}

}
