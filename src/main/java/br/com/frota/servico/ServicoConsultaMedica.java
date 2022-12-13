package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.DAO.LaboratorioDAO;
import br.com.frota.model.ConsultaMedica;


import java.sql.SQLException;

public class ServicoConsultaMedica {
    private ConsultaMedicaDAO consultaMedica = new ConsultaMedicaDAO();
    public void salvar(ConsultaMedica entidade) {
        consultaMedica.insertConsultaMedica(entidade);
    }

    public ConsultaMedica buscarPorId(int id) {
        return consultaMedica.findById(id);
    }

    public void update(ConsultaMedica consMed) throws SQLException {
        consultaMedica.updateConsultaMedica(consMed);
    }

    public void remover(int id) throws SQLException {
        consultaMedica.deleteConsultaMedica(id);
    }
}
