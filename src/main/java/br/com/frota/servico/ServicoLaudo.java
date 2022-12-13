package br.com.frota.servico;

import br.com.frota.DAO.ConsultaMedicaDAO;


import java.sql.SQLException;

public class ServicoLaudo {
    private LaudoDAO laudo = new LaudoDAO();
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
