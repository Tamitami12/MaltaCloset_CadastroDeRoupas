
package controller;

import java.util.List;

import model.ModelRoupas;
import model.RoupasRepositorio;

/**
 * Classe responsável por controlar as operações relacionadas
 * ao cadastro de roupas no sistema Malta Closet.
 *
 * Faz a comunicação entre as telas (View) e o repositório (Model),
 * encaminhando as solicitações de cadastro, listagem,
 * edição e exclusão de roupas.
 *
 * @author
 * @version 1.0
 */
public class ControllerRoupas {

    /** Repositório responsável por gerenciar as roupas cadastradas. */
    private RoupasRepositorio repositorio;

    /**
     * Construtor da classe ControllerRoupas.
     *
     * Cria uma instância do repositório para permitir
     * o gerenciamento das roupas.
     */
    public ControllerRoupas() {

        repositorio = new RoupasRepositorio();

    }

    /**
     * Cadastra uma nova roupa no sistema.
     *
     * Encaminha o objeto recebido para o método
     * cadastrar da classe RoupasRepositorio.
     *
     * @param roupa objeto contendo os dados da roupa
     */
    public void cadastrar(ModelRoupas roupa) {

        repositorio.cadastrar(roupa);

    }

    /**
     * Retorna a lista de roupas cadastradas.
     *
     * Solicita ao repositório os dados das roupas.
     *
     * @return lista de roupas cadastradas
     */
    public List<ModelRoupas> listar() {

        return repositorio.listar();

    }

    /**
     * Edita uma roupa já cadastrada.
     *
     * Encaminha a posição da roupa e os novos dados
     * para o repositório realizar a alteração.
     *
     * @param posicao posição da roupa que será editada
     * @param roupa objeto contendo os novos dados da roupa
     */
    public void editar(int posicao, ModelRoupas roupa) {

        repositorio.editar(posicao, roupa);

    }

    /**
     * Exclui uma roupa cadastrada no sistema.
     *
     * Encaminha o objeto para o repositório realizar
     * a remoção da lista.
     *
     * @param roupa objeto da roupa que será excluída
     */
    public void excluir(ModelRoupas roupa) {

        repositorio.excluir(roupa);

    }

}
