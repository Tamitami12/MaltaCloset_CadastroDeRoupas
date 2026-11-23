package view;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JColorChooser;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ControllerRoupas;
import model.ModelRoupas;

public class ViewListagem extends JFrame {

    private JTable tabela;
    private RoupasTableModel tabelaModel;
    private ControllerRoupas controller;
    
    private JPanel painelBotoes;
    private Color corFundo = Color.WHITE;
    private Color corBotoes = new Color(255, 182, 193);

    public ViewListagem() {

        controller = new ControllerRoupas();

        setTitle("Malta Closet - Cadastro de Roupas");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cria o menu superior
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");

        JMenuItem itemNovo = new JMenuItem("Novo Cadastro");

        itemNovo.addActionListener(e -> abrirCadastro());

        menuArquivo.add(itemNovo);
        barraMenu.add(menuArquivo);

        setJMenuBar(barraMenu);

        // Cria a tabela
        tabelaModel = new RoupasTableModel(controller.listar());

        tabela = new JTable(tabelaModel);

        JScrollPane painelTabela = new JScrollPane(tabela);

        add(painelTabela, BorderLayout.CENTER);

        // Cria os botões
        painelBotoes = new JPanel();
        
        painelBotoes.setLayout(new FlowLayout());

        JButton botaoNovo = new JButton("Novo");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoSair = new JButton("Sair");
        JButton botaoCores = new JButton("Personalizar cores");

        botaoNovo.addActionListener(e -> abrirCadastro());

        botaoEditar.addActionListener(e -> editarRoupa());

        botaoExcluir.addActionListener(e -> excluirRoupa());

        botaoSair.addActionListener(e -> dispose());
        
        botaoCores.addActionListener(e -> personalizarCores());

        painelBotoes.add(botaoNovo);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoSair);
        painelBotoes.add(botaoCores);

        add(painelBotoes, BorderLayout.SOUTH);

    }

    // Abre a tela de cadastro
    private void abrirCadastro() {

        ViewRoupas tela = new ViewRoupas(controller, this, null, -1);

        tela.setVisible(true);

    }

    // Abre a tela para editar uma roupa
    private void editarRoupa() {

        int linha = tabela.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this,
                    "Selecione uma roupa para editar!");

            return;

        }

        ModelRoupas roupa = controller.listar().get(linha);

        ViewRoupas tela = new ViewRoupas(controller, this, roupa, linha);

        tela.setVisible(true);

    }

    // Exclui uma roupa selecionada
    private void excluirRoupa() {

        int linha = tabela.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(this,
                    "Selecione uma roupa para excluir!");

            return;

        }

        int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja realmente excluir esta roupa?",
                "Confirmar exclusão",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            ModelRoupas roupa = controller.listar().get(linha);

            controller.excluir(roupa);

            atualizarTabela();

            JOptionPane.showMessageDialog(this,
                    "Roupa excluída com sucesso!");

        }

    }

    // Atualiza os dados da tabela
    public void atualizarTabela() {

        List<ModelRoupas> roupas = controller.listar();

        tabelaModel.atualizarTabela(roupas);

    }
    

    private void personalizarCores() {
    	Color novaCorFundo = JColorChooser.showDialog(this, "Escolha a cor de fundo",corFundo);
    	
    	if (novaCorFundo != null) {
    		corFundo = novaCorFundo;
    	}
    	
    	Color novaCorBotoes = JColorChooser.showDialog(this, "Escolha a cor dos botões", corBotoes);

    	if (novaCorBotoes != null) {
        corBotoes = novaCorBotoes;

    	}

    	getContentPane().setBackground(corFundo);
    	painelBotoes.setBackground(corFundo);

    		for (java.awt.Component componente : painelBotoes.getComponents()) {

    			if (componente instanceof JButton) {
    				componente.setBackground(corBotoes);
    				componente.setForeground(Color.BLACK);
    				
    				((JButton) componente).setOpaque(true);

    			}

    		}

    		repaint();

    }


}
