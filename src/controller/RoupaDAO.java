
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.ModelRoupas;

/**
 * Classe responsável por salvar e carregar os dados das roupas
 * em um arquivo chamado roupas.dat.
 *
 * Utiliza a serialização de objetos para armazenar a lista
 * de roupas e recuperar os dados quando o sistema for aberto.
 *
 * @author
 * @version 1.0
 */
public class RoupaDAO {

    /** Caminho e nome do arquivo onde as roupas serão armazenadas. */
    private final String caminhoArquivo = "roupas.dat";

    /**
     * Salva a lista de roupas no arquivo.
     *
     * Utiliza ObjectOutputStream para gravar os objetos.
     * Caso ocorra algum erro durante o salvamento,
     * uma mensagem será exibida no console.
     *
     * @param lista lista contendo as roupas que serão salvas
     */
    public void salvar(List<ModelRoupas> lista) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(caminhoArquivo))) {

            oos.writeObject(lista);

        } catch (IOException e) {

            System.err.println("Erro ao salvar as roupas: " + e.getMessage());

        }

    }

    /**
     * Carrega a lista de roupas armazenada no arquivo.
     *
     * Primeiro verifica se o arquivo existe.
     * Caso não exista, retorna uma lista vazia.
     * Se existir, utiliza ObjectInputStream para recuperar
     * os objetos armazenados.
     *
     * @return lista de roupas carregadas ou uma lista vazia
     *         caso o arquivo não exista ou ocorra algum erro
     */
    @SuppressWarnings("unchecked")
    public List<ModelRoupas> carregar() {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {

            return new ArrayList<>();

        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arquivo))) {

            return (List<ModelRoupas>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.err.println("Erro ao ler as roupas: " + e.getMessage());

            return new ArrayList<>();

        }

    }

}
