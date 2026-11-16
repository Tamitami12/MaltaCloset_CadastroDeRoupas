package model;

import java.util.ArrayList;
import java.util.List;

import controller.RoupaDAO;

public class RoupasRepositorio {
	
	private List<ModelRoupas> roupas;
	private RoupaDAO dao;
	
	public RoupasRepositorio(){
		dao = new RoupaDAO();
		roupas = dao.carregar();
	}
	
	public void cadastrar(ModelRoupas roupa) {
		roupas.add(roupa);
		dao.salvar(roupas);
	}
	
	public List<ModelRoupas> listar(){
		return new ArrayList<ModelRoupas>(roupas);
	}
	
	public void editar(int posicao, ModelRoupas roupa) {
		roupas.set(posicao, roupa);
		dao.salvar(roupas);
	}
	
	public void excluir(ModelRoupas roupa) {
		roupas.remove(roupa);
		dao.salvar(roupas);
	}
	
	public int buscarPosicao(ModelRoupas roupa) {
		return roupas.indexOf(roupa);
	}

}
