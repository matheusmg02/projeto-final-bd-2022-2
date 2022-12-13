package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.DAO.HabilitacaoExameDAO;
import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.HabilitacaoExame;

import java.sql.SQLException;

public class ServicoHabilitacaoExame {
    private HabilitacaoExameDAO habilitacaoExame = new HabilitacaoExameDAO();
    public void salvar(HabilitacaoExame entidade) {
        habilitacaoExame.insertHabilitacaoExame(entidade);
    }

    public HabilitacaoExame buscarPorId(int id) {
        return habilitacaoExame.findById(id);
    }

    public void update(HabilitacaoExame habExam) throws SQLException {
        habilitacaoExame.updateHabilitacaoExame(habExam);
    }

    public void remover(int id) throws SQLException {
        habilitacaoExame.deleteHabilitacaoExame(id);
    }
}
