package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.DAO.SolicitacaoExameDAO;
import br.com.frota.model.ConsultaMedica;
import br.com.frota.model.SolicitacaoExame;

import java.sql.SQLException;

public class ServicoSolicitacaoExame {
    private SolicitacaoExameDAO solicitacaoExame = new SolicitacaoExameDAO();
    public void salvar(SolicitacaoExame entidade) {
        solicitacaoExame.insertSolicitacaoExame(entidade);
    }

    public SolicitacaoExame buscarPorId(int id) {
        return solicitacaoExame.findById(id);
    }

    public void update(SolicitacaoExame solicExam) throws SQLException {
        solicitacaoExame.updateSolicitacaoExame(solicExam);
    }

    public void remover(int id) throws SQLException {
        solicitacaoExame.deleteSolicitacaoExame(id);
    }
}
