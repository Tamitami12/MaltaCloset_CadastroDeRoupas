package view;

import java.awt.BorderLayout;
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
        JPanel painelBotoes = new JPanel();

        painelBotoes.setLayout(new FlowLayout());

        JButton botaoNovo = new JButton("Novo");
        JButton botaoEditar = new JButton("Editar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoSair = new JButton("Sair");

        botaoNovo.addActionListener(e -> abrirCadastro());

        botaoEditar.addActionListener(e -> editarRoupa());

        botaoExcluir.addActionListener(e -> excluirRoupa());

        botaoSair.addActionListener(e -> dispose());

        painelBotoes.add(botaoNovo);
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoSair);

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

}
