package br.com.frota.servico;

import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.DAO.MedicoDAO;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.Medico;

import java.sql.SQLException;

public class ServicoMedico {
    private MedicoDAO medico = new MedicoDAO();
    public void salvar(Medico entidade) {
        medico.insertMedico(entidade);
    }

    public Medico buscarPorId(int id) {
        return medico.findById(id);
    }

    public void update(Medico med) throws SQLException {
        medico.updateMedico(med);
    }

    public void remover(int id) throws SQLException {
        medico.deleteMedico(id);
    }
}
