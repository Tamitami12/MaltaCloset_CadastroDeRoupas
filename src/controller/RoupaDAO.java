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

public class RoupaDAO {

    private final String caminhoArquivo = "roupas.dat";
  
    public void salvar(List<ModelRoupas> lista) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(caminhoArquivo))) {

            oos.writeObject(lista);

        } catch (IOException e) {

            System.err.println("Erro ao salvar as roupas: " + e.getMessage());

        }

    }

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

