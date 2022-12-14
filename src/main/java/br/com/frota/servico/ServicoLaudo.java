package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.DAO.LaudoDAO;
import br.com.frota.model.Laudo;


import java.sql.SQLException;

public class ServicoLaudo {
    private LaudoDAO laudo = new LaudoDAO();
    public void salvar(Laudo entidade) {
        laudo.insertLaudo(entidade);
    }

    public Laudo buscarPorId(int id) {
        return laudo.findById(id);
    }

    public void update(Laudo consMed) throws SQLException {
        laudo.updateLaudo(consMed);
    }

    public void remover(int id) throws SQLException {
        laudo.deleteLaudo(id);
    }
}
