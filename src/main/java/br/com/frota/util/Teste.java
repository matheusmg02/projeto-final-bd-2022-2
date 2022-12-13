package br.com.frota.util;

import br.com.frota.model.Composicao;
import br.com.frota.model.Laboratorio;
import br.com.frota.servico.ServicoLaboratorio;
import br.com.frota.servico.ServicoMarca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        Laboratorio lab = new Laboratorio( "proj", "teste", "----", "mat", "a");
        ServicoLaboratorio servicoLab = new ServicoLaboratorio();

        servicoLab.salvar(lab);


    }
}


