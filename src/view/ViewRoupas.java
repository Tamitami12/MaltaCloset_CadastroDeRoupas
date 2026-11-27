
package view;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerRoupas;
import model.ModelRoupas;

/**
 * Classe responsável pela interface gráfica de cadastro e edição de roupas.
 * Permite preencher os dados de uma roupa, gravar um novo cadastro
 * ou editar uma roupa já existente.
 */
public class ViewRoupas extends JFrame {

    /** Campo de texto para informar o nome da roupa. */
    private JTextField campoNome;

    /** Lista de opções para selecionar a categoria da roupa. */
    private JComboBox<String> campoCategoria;

    /** Lista de opções para selecionar o tamanho da roupa. */
    private JComboBox<String> campoTamanho;

    /** Campo de texto para informar a cor da roupa. */
    private JTextField campoCor;

    /** Área de texto para informar a descrição da roupa. */
    private JTextArea campoDescricao;

    /** Campo de texto para informar o preço da roupa. */
    private JTextField campoPreco;

    /** Campo de texto para informar a quantidade de roupas. */
    private JTextField campoQuantidade;

    /** Caixa de seleção para indicar se a roupa é destaque. */
    private JCheckBox campoDestaque;

    /** Controller responsável pelas operações com as roupas. */
    private ControllerRoupas controller;

    /** Referência à tela principal de listagem de roupas. */
    private ViewListagem telaPrincipal;

    /** Roupa que será editada, caso exista. */
    private ModelRoupas roupa;

    /** Posição da roupa na lista durante a edição. */
    private int posicao;

    /**
     * Construtor responsável por criar a janela de cadastro de roupas.
     * Configura a interface, cria os campos, os botões e suas ações.
     *
     * @param controller controlador responsável pelas operações com roupas
     * @param telaPrincipal tela principal de listagem
     * @param roupa roupa que será editada, ou null para novo cadastro
     * @param posicao posição da roupa na lista para realizar a edição
     */
    public ViewRoupas(ControllerRoupas controller,
            ViewListagem telaPrincipal, ModelRoupas roupa, int posicao) {

        this.controller = controller;
        this.telaPrincipal = telaPrincipal;
        this.roupa = roupa;
        this.posicao = posicao;

        setTitle("Malta Closet - Cadastro de Roupas");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(9, 2, 5, 5));

        campoNome = new JTextField();

        campoCategoria = new JComboBox<>(new String[] {
            "Blusa", "Calça", "Vestido", "Saia", "Casaco", "Outro"
        });

        campoTamanho = new JComboBox<>(new String[] {
            "PP", "P", "M", "G", "GG", "Único"
        });

        campoCor = new JTextField();

        campoDescricao = new JTextArea();

        campoPreco = new JTextField();

        campoQuantidade = new JTextField();

        campoDestaque = new JCheckBox("Sim");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);

        painel.add(new JLabel("Categoria:"));
        painel.add(campoCategoria);

        painel.add(new JLabel("Tamanho:"));
        painel.add(campoTamanho);

        painel.add(new JLabel("Cor:"));
        painel.add(campoCor);

        painel.add(new JLabel("Descrição:"));
        painel.add(campoDescricao);

        painel.add(new JLabel("Preço:"));
        painel.add(campoPreco);

        painel.add(new JLabel("Quantidade:"));
        painel.add(campoQuantidade);

        painel.add(new JLabel("Destaque:"));
        painel.add(campoDestaque);

        JButton botaoGravar = new JButton("Gravar");
        JButton botaoCancelar = new JButton("Cancelar");

        painel.add(botaoGravar);
        painel.add(botaoCancelar);

        add(painel, BorderLayout.CENTER);

        botaoGravar.addActionListener(e -> gravar());

        botaoCancelar.addActionListener(e -> dispose());

        if (roupa != null) {
            preencherCampos();
            botaoGravar.setText("Editar");
        }

    }

    /**
     * Preenche os campos da interface com os dados da roupa selecionada.
     * Utilizado quando a janela é aberta para editar um cadastro existente.
     */
    private void preencherCampos() {

        campoNome.setText(roupa.getNome());
        campoCategoria.setSelectedItem(roupa.getCategoria());
        campoTamanho.setSelectedItem(roupa.getTamanho());
        campoCor.setText(roupa.getCor());
        campoDescricao.setText(roupa.getDescricao());
        campoPreco.setText(String.valueOf(roupa.getPreco()));
        campoQuantidade.setText(String.valueOf(roupa.getQuantidade()));
        campoDestaque.setSelected(roupa.isDestaque());

    }

    /**
     * Obtém os dados preenchidos na interface, valida as informações
     * e realiza o cadastro ou a edição de uma roupa.
     * Também exibe mensagens de confirmação ou de erro.
     */
    private void gravar() {

        try {

            String nome = campoNome.getText();
            String categoria = campoCategoria.getSelectedItem().toString();
            String tamanho = campoTamanho.getSelectedItem().toString();
            String cor = campoCor.getText();
            String descricao = campoDescricao.getText();
            double preco = Double.parseDouble(campoPreco.getText().replace(",", "."));
            int quantidade = Integer.parseInt(campoQuantidade.getText());
            boolean destaque = campoDestaque.isSelected();

            if (nome.trim().isEmpty() || cor.trim().isEmpty()
                    || descricao.trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Preencha todos os campos!");

                return;

            }

            if (preco < 0 || quantidade < 0) {

                JOptionPane.showMessageDialog(this,
                        "Preço e quantidade não podem ser negativos!");

                return;

            }

            ModelRoupas novaRoupa = new ModelRoupas(
                    nome, categoria, tamanho, cor, descricao,
                    preco, quantidade, destaque);

            if (roupa == null) {

                controller.cadastrar(novaRoupa);

                JOptionPane.showMessageDialog(this,
                        "Roupa cadastrada com sucesso!");

            } else {

                controller.editar(posicao, novaRoupa);

                JOptionPane.showMessageDialog(this,
                        "Roupa editada com sucesso!");

            }

            telaPrincipal.atualizarTabela();

            dispose();

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Digite um preço e uma quantidade válidos!");

        }

    }

}
