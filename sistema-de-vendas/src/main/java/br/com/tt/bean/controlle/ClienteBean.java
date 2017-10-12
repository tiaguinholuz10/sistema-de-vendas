package br.com.tt.bean.controlle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.dao.Dao;
import br.com.tt.dao.IDao;
import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean(name = "cliente")
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	private List<Cliente> clientes;
	private IDao<Cliente> dao;
	private Endereco endereco;

	@PostConstruct
	private void init() {

		dao = new Dao<Cliente>(Cliente.class);
		cliente = new Cliente();
		clientes = new ArrayList<Cliente>();
		clientes = dao.consultar();
		endereco = new Endereco();

	}

	public void salvar() {

		try {

			cliente.setEndereco(endereco);
			dao.salvar(cliente);
			clientes = dao.consultar();
			MessageUtil.info("Cliente Salvo", "Cliente salvo com sucesso");
			cliente = new Cliente();
			endereco = new Endereco();

		} catch (Exception e) {

			e.printStackTrace();
			MessageUtil.error("ERROR: Já existe uma inscrição para este CPF.",
					" Ocorreu um problema no cadastro do Cliente." + " - Verifique os *Campos Obrigatórios");
		} 

		/*
		 * System.out.println("Salvando \n\t" + cliente.getNome() + "\n\t" +
		 * cliente.getCpf()); MessageUtil.info("Salvo", cliente.getNome() +
		 * " Salvo com sucesso"); clientes.add(cliente); cliente = new
		 * Cliente();
		 */
	}

	public void alterar(Cliente cliente) {

		this.cliente = cliente;
		this.endereco = cliente.getEndereco();

	}

	public void excluir() {

		MessageUtil.warn("", cliente.getNome() + " Foi Excluido!");
		dao.excluir(cliente.getId());
		clientes = dao.consultar();
		cliente = new Cliente();
		endereco = new Endereco();
		

	}

	public void cancelar() {
		
		
		
		MessageUtil.warn("O cadastro foi cancelado! ", " O cadastro foi cancelado!  ");
		cliente = new Cliente();
		endereco = new Endereco();
		

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Cliente> getClientes() {

		cliente.setEndereco(cliente.getEndereco());
		for (Cliente cliente : clientes) {
			System.out.println("Lista " + cliente.getId()+" | "+ cliente.getNome()+" | "+ cliente.getEndereco());
		}
		return clientes;
	}

}
