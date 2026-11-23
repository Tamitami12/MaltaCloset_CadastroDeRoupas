package model;

import java.util.ArrayList;
import java.util.List;

import controller.RoupaDAO;

/**
 * Essa classe é responsável por gerenciar as roupas cadastradas
 * no sistema Malta Closet.
 *
 * Permite cadastrar, listar, editar, excluir e buscar
 * a posição das roupas.
 *
 * Também utiliza a classe RoupaDAO para salvar os dados
 * e carregar as roupas armazenadas no arquivo.
 *
 */

public class RoupasRepositorio {
	
    /** Lista que armazena as roupas cadastradas. */
	private List<ModelRoupas> roupas;
	
	/** Objeto responsável por salvar e carregar os dados. */
	private RoupaDAO dao;
	
	/**
     * Construtor da classe RoupasRepositorio.
     *
     * Inicializa o DAO e carrega as roupas que já estão salvas no arquivo.
     */
	public RoupasRepositorio(){
		dao = new RoupaDAO();
		
	/**
	 * dao.carregar recupera as roupas salvas antes
	 */
		roupas = dao.carregar();
	}
	
	/**
     * Cadastra uma nova roupa no repositório.
     *
     * Adiciona a roupa na lista e salva a lista atualizada no arquivo.
     *
     * @param roupa Objeto contendo os dados da roupa
     */
	public void cadastrar(ModelRoupas roupa) {
		roupas.add(roupa);
	/**
	 * dao.salvar grava alterações no arquivo
	 */
		dao.salvar(roupas);
	}
	
	/**
     * Retorna a lista de roupas cadastradas.
     *
     * Cria uma nova lista com os mesmos elementos, evitando entregar 
     * diretamente a lista original.
     *
     * @return lista Contendo as roupas cadastradas
     */
	public List<ModelRoupas> listar(){
		return new ArrayList<ModelRoupas>(roupas);
	}
	
	 /**
     * Edita uma roupa já cadastrada.
     *
     * Substitui a roupa que está na posição informada pela nova roupa 
     * e salva as alterações no arquivo.
     *
     * @param posicao Posição da roupa que será editada
     * @param roupa Objeto com os novos dados da roupa
     */
	public void editar(int posicao, ModelRoupas roupa) {
		roupas.set(posicao, roupa);
		dao.salvar(roupas);
	}
	
	/**
     * Exclui uma roupa do repositório.
     *
     * Remove a roupa da lista e salva a lista atualizada no arquivo.
     *
     * @param roupa Objeto da roupa que será excluída
     */
	public void excluir(ModelRoupas roupa) {
		roupas.remove(roupa);
		dao.salvar(roupas);
	}

}
