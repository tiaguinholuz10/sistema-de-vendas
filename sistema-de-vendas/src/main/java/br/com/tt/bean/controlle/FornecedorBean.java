package br.com.tt.bean.controlle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.dao.Dao;
import br.com.tt.dao.IDao;
import br.com.tt.model.Endereco;
import br.com.tt.model.Fornecedor;
import br.com.tt.util.CnpjUtil;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean(name = "fornecedorBean")
@SessionScoped
public class FornecedorBean {

	private Fornecedor fornecedor;
	private Endereco endereco;
	private List<Fornecedor> fornecedores;
	private IDao<Fornecedor> dao;

	@PostConstruct
	private void init() {

		dao = new Dao<Fornecedor>(Fornecedor.class);
		fornecedor = new Fornecedor();
		endereco = new Endereco();
		fornecedores = new ArrayList<Fornecedor>();
		fornecedores = dao.consultar();

	}

	public void salvar() {

		try {

			fornecedor.setEndereco(endereco);
			dao.salvar(fornecedor);
			fornecedores = dao.consultar();
			MessageUtil.info("Fornecedor Salvo", "Fornecedor salvo com sucesso");

		} catch (Exception e) {

			MessageUtil.error("Error ao Cadastrar Dados - Verifique se  ", " *Error ao Gravar Dados...");

		} finally {

			fornecedor = new Fornecedor();
			endereco = new Endereco();

		}
	}

	public void cancelar() {

		MessageUtil.warn("O Cadastro foi Cancelado...", " Cancelado o Cadastro!");
		fornecedor = new Fornecedor();
		endereco = new Endereco();

	}

	public void alterar(Fornecedor fornecedor) {

		this.fornecedor = fornecedor;
		this.endereco = fornecedor.getEndereco();

	}

	public void excluir(Fornecedor fornecedor) {

		MessageUtil.warn(" Foi Excluido!",
				"O CNPJ: " + CnpjUtil.adicionarMarcara(fornecedor.getCnpj()) + " foi excluido com sucesso.");
		dao.excluir(fornecedor.getId());
		fornecedores = dao.consultar();
		fornecedor = new Fornecedor();
		endereco = new Endereco();

	}

	public List<Fornecedor> getFornecedores() {
		fornecedor.setEndereco(fornecedor.getEndereco());
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("Lista " + fornecedor.getCnpj()+ " | " + " Endereço-> " + fornecedor.getEndereco());
		}
		return fornecedores;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Endereco getEndereco() {

		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
