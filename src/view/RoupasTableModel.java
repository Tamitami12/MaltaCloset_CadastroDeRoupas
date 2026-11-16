package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import model.ModelRoupas;

public class RoupasTableModel extends AbstractTableModel {
    private String[] colunas = {
        "Nome", "Categoria", "Tamanho", "Cor",
        "Descrição", "Preço", "Quantidade", "Destaque"
    };

    private List<ModelRoupas> roupas;

    public RoupasTableModel(List<ModelRoupas> roupas) {
        this.roupas = roupas;

    }

    @Override
    public int getRowCount() {
        return roupas.size();

    }

    @Override
    public int getColumnCount() {
        return colunas.length;

    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];

    }

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

    public void atualizarTabela(List<ModelRoupas> roupas) {
        this.roupas = roupas;

        fireTableDataChanged();

    }

}

