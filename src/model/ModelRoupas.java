package model;

import java.io.Serializable;

/**
 * Essa classe representa uma roupa cadastrada no sistema Malta Closet.
 * 
 * Armazena as informações principais de cada roupa como nome, categoria, 
 * tamanho, cor, descrição, preço, quantidade e destaque.
 * 
 * Implementa Serializable para permitir que os objetos
 * sejam salvos em arquivos.
 */

public class ModelRoupas implements Serializable {
	
	private String nome;
	private String categoria;
	private String tamanho;
	private String cor;
	private String descricao;
	private double preco;
	private int quantidade;
	private boolean destaque;

	 /**
     * Construtor da classe ModelRoupas.
     * Inicializa uma roupa com todas as suas informações.
     * 
     * this: referencia o proprio objeto
     *
     * @param nome Para nome da roupa
     * @param categoria Para categoria da roupa
     * @param tamanho Para tamanho da roupa
     * @param cor Para cor da roupa
     * @param descricao Para descrição da roupa
     * @param preco Para preço da roupa
     * @param quantidade Para quantidade disponível
     * @param destaque Que indica se a roupa é destaque ou não
     */
	public ModelRoupas(String nome, String categoria, String tamanho, String cor, String descricao, double preco, int quantidade, boolean destaque) {
		this.nome = nome;
		this.categoria = categoria;
		this.tamanho = tamanho;
		this.cor = cor;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.destaque = destaque;
	}

	 /**
     * Retorna o nome da roupa.
     *
     * @return nome da roupa
     */
	public String getNome() {
		return nome;
	}

	 /**
     * Retorna a categoria da roupa.
     *
     * @return categoria da roupa
     */
	public String getCategoria() {
		return categoria;
	}

	 /**
     * Retorna o tamanho da roupa.
     *
     * @return tamanho da roupa
     */
	public String getTamanho() {
		return tamanho;
	}

	/**
     * Retorna a cor da roupa.
     *
     * @return cor da roupa
     */
	public String getCor() {
		return cor;
	}

	/**
     * Retorna a descrição da roupa.
     *
     * @return descrição da roupa
     */
	public String getDescricao() {
		return descricao;
	}

	/**
     * Retorna o preço da roupa.
     *
     * @return preço da roupa
     */
	public double getPreco() {
		return preco;
	}

	 /**
     * Retorna a quantidade disponível da roupa.
     *
     * @return quantidade disponível
     */
	public int getQuantidade() {
		return quantidade;
	}

	/**
     * Verifica se a roupa está marcada como destaque.
     * 
     * Utiliza-se isDestaque() por ser um atributo booleano 
     * que retorna true ou false
     *
     * @return true se for destaque, ou false caso contrário
     */
	public boolean isDestaque() {
		return destaque;
	}
	
	

}
