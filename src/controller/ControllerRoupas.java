package controller;

import java.util.List;

import model.ModelRoupas;
import model.RoupasRepositorio;;

public class ControllerRoupas {
	private RoupasRepositorio repositorio;
	
	public ControllerRoupas() {
		repositorio = new RoupasRepositorio();
		
	}
	
	public void cadastrar(ModelRoupas roupa) {
		repositorio.cadastrar(roupa);
	}
	
	public List<ModelRoupas> listar(){
		return repositorio.listar();
	}
	
	public void editar(int posicao, ModelRoupas roupa) {
		repositorio.editar(posicao, roupa);
	}
	
	public void excluir(ModelRoupas roupa) {
		repositorio.excluir(roupa);
	}
	
	public int buscarPosicao(ModelRoupas roupa) {
		return repositorio.buscarPosicao(roupa);
	}

}
