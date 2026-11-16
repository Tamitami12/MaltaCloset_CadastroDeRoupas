package main;

import javax.swing.SwingUtilities;
import view.ViewListagem;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            ViewListagem tela = new ViewListagem();
            tela.setVisible(true);

        });

    }

}

