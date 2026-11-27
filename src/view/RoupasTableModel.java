
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.ModelRoupas;

/**
 * Classe responsável por organizar os dados das roupas
 * para exibição em uma tabela (JTable).
 *
 * Define as colunas, a quantidade de linhas e os dados
 * que serão apresentados em cada célula da tabela.
 *
 * @author
 * @version 1.0
 */
public class RoupasTableModel extends AbstractTableModel {

    /** Nomes das colunas que serão exibidas na tabela. */
    private String[] colunas = {
        "Nome", "Categoria", "Tamanho", "Cor",
        "Descrição", "Preço", "Quantidade", "Destaque"
    };

    /** Lista de roupas que será utilizada para preencher a tabela. */
    private List<ModelRoupas> roupas;

    /**
     * Construtor da classe RoupasTableModel.
     *
     * Recebe a lista de roupas que será exibida na tabela.
     *
     * @param roupas lista de roupas cadastradas
     */
    public RoupasTableModel(List<ModelRoupas> roupas) {

        this.roupas = roupas;

    }

    /**
     * Retorna a quantidade de linhas da tabela.
     *
     * A quantidade de linhas corresponde ao número
     * de roupas cadastradas na lista.
     *
     * @return quantidade de roupas cadastradas
     */
    @Override
    public int getRowCount() {

        return roupas.size();

    }

    /**
     * Retorna a quantidade de colunas da tabela.
     *
     * @return quantidade de colunas definidas no vetor colunas
     */
    @Override
    public int getColumnCount() {

        return colunas.length;

    }

    /**
     * Retorna o nome de uma coluna da tabela.
     *
     * @param coluna índice da coluna
     * @return nome da coluna correspondente ao índice informado
     */
    @Override
    public String getColumnName(int coluna) {

        return colunas[coluna];

    }

    /**
     * Retorna o valor que será exibido em uma célula da tabela.
     *
     * Utiliza a linha e a coluna informadas para localizar
     * a roupa e retornar o atributo correspondente.
     *
     * @param linha índice da linha
     * @param coluna índice da coluna
     * @return valor do atributo correspondente à célula,
     *         ou null se a coluna não for reconhecida
     */
    @Override
    public Object getValueAt(int linha, int coluna) {

        ModelRoupas roupa = roupas.get(linha);

        switch (coluna) {

            case 0:
                return roupa.getNome();

            case 1:
                return roupa.getCategoria();

            case 2:
                return roupa.getTamanho();

            case 3:
                return roupa.getCor();

            case 4:
                return roupa.getDescricao();

            case 5:
                return roupa.getPreco();

            case 6:
                return roupa.getQuantidade();

            case 7:
                return roupa.isDestaque();

            default:
                return null;

        }

    }

    /**
     * Atualiza os dados utilizados pela tabela.
     *
     * Substitui a lista atual pela nova lista recebida
     * e avisa à tabela que seus dados foram modificados,
     * permitindo que a exibição seja atualizada.
     *
     * @param roupas nova lista de roupas
     */
    public void atualizarTabela(List<ModelRoupas> roupas) {

        this.roupas = roupas;

        fireTableDataChanged();

    }

}
