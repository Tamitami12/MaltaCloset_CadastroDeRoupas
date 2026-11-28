
package main;

import javax.swing.SwingUtilities;
import view.ViewListagem;

/**
 * Classe principal do sistema Malta Closet.
 * Responsável por iniciar a aplicação e abrir a tela principal.
 */
public class Main {

    /**
     * Método principal que inicia a execução do programa.
     *
     * Utiliza o SwingUtilities.invokeLater() para criar e exibir
     * a interface da fila de eventos do Swing.
     * @param args argumentos recebidos na execução do programa
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
        	
        	/**
             * new: cria o objeto da tela principal.
             * setVisible(true): exibe a janela.
             */

            ViewListagem tela = new ViewListagem();
            tela.setVisible(true);

        });

    }

}
