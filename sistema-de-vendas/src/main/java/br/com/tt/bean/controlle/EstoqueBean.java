package br.com.tt.bean.controlle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.dao.Dao;
import br.com.tt.dao.IDao;
import br.com.tt.model.Estoque;
import br.com.tt.util.faces.MessageUtil;

@ManagedBean(name = "estoque")
@SessionScoped
public class EstoqueBean {

	private Estoque estoque;
	private List<Estoque> estoques;
	private IDao<Estoque> dao;

	@PostConstruct
	private void init() {
		dao = new Dao<Estoque>(Estoque.class);
		estoque = new Estoque();
		estoques = new ArrayList<Estoque>();
		estoques = dao.consultar();

	}

	public void salvar() {

		dao.salvar(estoque);
		estoques = dao.consultar();
		MessageUtil.info("Salvo", "Cadastro no estoque salvo com sucesso.");
		estoque = new Estoque();

	}

	public void cancelar() {
		MessageUtil.warn("Cancelado", "Cancelado" + " Cancelado o cadastro!");
		estoque = new Estoque();
	}

	public void alterar(Estoque estoque) {
		this.estoque = estoque;

	}

	public void excluir() {
		MessageUtil.warn("", estoque.getId() + " Foi Excluido!");
		dao.excluir(estoque.getId());
		estoques = dao.consultar();

	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public IDao<Estoque> getDao() {
		return dao;
	}

	public void setDao(IDao<Estoque> dao) {
		this.dao = dao;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public List<Estoque> getEstoques() {

		for (Estoque estoque : estoques) {
			System.out.println("Lista " + estoque.getId());
		}
		return estoques;
	}

}
