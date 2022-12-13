package br.com.frota.servico;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.TipoExame;

import java.sql.SQLException;

public class ServicoTipoExame {
    private TipoExameDAO tipoExame = new TipoExameDAO();
    public void salvar(TipoExame entidade) {
        tipoExame.insertTipoExame(entidade);
    }

    public TipoExame buscarPorId(int id) {
        return tipoExame.findById(id);
    }

    public void update(TipoExame tipoExam) throws SQLException {
        tipoExame.updateTipoExame(tipoExam);
    }

    public void remover(int id) throws SQLException {
        tipoExame.deleteTipoExame(id);
    }
}
