package br.com.frota.servico;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.DAO.ConsultaMedicaDAO;
import br.com.frota.model.Composicao;
import br.com.frota.model.ConsultaMedica;

import java.sql.SQLException;

public class ServicoComposicao {
    private ComposicaoDAO composicao = new ComposicaoDAO();
    public void salvar(Composicao entidade) {
        composicao.insertComposicao(entidade);
    }

    public Composicao buscarPorId(int id) {
        return composicao.findById(id);
    }

    public void update(Composicao comp) throws SQLException {
        composicao.updateComposicao(comp);
    }

    public void remover(int id) throws SQLException {
        composicao.deleteComposicao(id);
    }
}
