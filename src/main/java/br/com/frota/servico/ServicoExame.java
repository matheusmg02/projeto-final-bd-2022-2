package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.Exame;

import java.sql.SQLException;

public class ServicoExame {
    private ExameDAO exame = new ExameDAO();
    public void salvar(Exame entidade) {
        exame.insertExame(entidade);
    }

    public Exame buscarPorId(int id) {
        return exame.findById(id);
    }

    public void update(Exame exam) throws SQLException {
        exame.updateExame(exam);
    }

    public void remover(int id) throws SQLException {
        exame.deleteExame(id);
    }
}
