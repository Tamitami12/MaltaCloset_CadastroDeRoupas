package model;

import java.io.Serializable;

public class ModelRoupas implements Serializable {
	
	private String nome;
	private String categoria;
	private String tamanho;
	private String cor;
	private String descricao;
	private double preco;
	private int quantidade;
	private boolean destaque;

	
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


	public String getNome() {
		return nome;
	}


	public String getCategoria() {
		return categoria;
	}


	public String getTamanho() {
		return tamanho;
	}


	public String getCor() {
		return cor;
	}


	public String getDescricao() {
		return descricao;
	}


	public double getPreco() {
		return preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public boolean isDestaque() {
		return destaque;
	}
	
	

}
