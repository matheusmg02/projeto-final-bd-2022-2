package br.com.frota.DAO;

import br.com.frota.model.Composicao;
import br.com.frota.model.ComposicaoExame;
import br.com.frota.model.Exame;
import br.com.frota.model.ValorReferenciaComposicaoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComposicaoDAO extends ConexaoDB{
    private static final String INSERT_COMPOSICAO_SQL = "INSERT INTO composicao (exame_id, composicao_exame_id, valor_referencia_composicao_exame_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_COMPOSICAO_BY_ID = "SELECT id, exame_id, composicao_exame_id, valor_referencia_composicao_exame_id FROM composicao WHERE id = ?";
    private static final String SELECT_ALL_COMPOSICAO = "SELECT * FROM composicao;";
    private static final String DELETE_COMPOSICAO_SQL = "DELETE FROM composicao WHERE id = ?;";
    private static final String UPDATE_COMPOSICAO_SQL = "UPDATE composicao SET exame_id = ?, composicao_exame_id = ? valor_referencia_composicao_exame_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM composicao;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public void insertComposicao(Composicao entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_COMPOSICAO_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entidade.getExameId().getId());
            preparedStatement.setInt(2, entidade.getComposicaoExameId().getId());
            preparedStatement.setInt(3, entidade.getValorReferenciaComposicaoExameId().getId());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                entidade.setId(result.getInt(1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Composicao findById(int id) {
        Composicao entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_COMPOSICAO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int exameId = rs.getInt("exame_id");
                ExameDAO exam = new ExameDAO();
                Exame exame = exam.findById(exameId);
                int composicaoExameId = rs.getInt("composicao_exame_id");
                ComposicaoExameDAO compExame = new ComposicaoExameDAO();
                ComposicaoExame comExame = compExame.findById(composicaoExameId);
                int valorReferenciaComposicaoExameId = rs.getInt("valor_referencia_composicao_exame_id");
                ValorReferenciaComposicaoExame valRef = new ValorReferenciaComposicaoExameDAO().findById(valorReferenciaComposicaoExameId);
                entidade = new Composicao(id, exame, comExame, valRef);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Composicao> selectAllComposicao() {
        List<Composicao> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_COMPOSICAO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int exameId = rs.getInt("exame_id");
                ExameDAO exam = new ExameDAO();
                Exame exame = exam.findById(exameId);
                int composicaoExameId = rs.getInt("composicao_exame_id");
                ComposicaoExameDAO compExame = new ComposicaoExameDAO();
                ComposicaoExame comExame = compExame.findById(composicaoExameId);
                int valorReferenciaComposicaoExameId = rs.getInt("valor_referencia_composicao_exame_id");
                ValorReferenciaComposicaoExame valRef = new ValorReferenciaComposicaoExameDAO().findById(valorReferenciaComposicaoExameId);
                entidades.add(new Composicao(id, exame, comExame, valRef));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteComposicao(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_COMPOSICAO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateComposicao(Composicao entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_COMPOSICAO_SQL)) {
            statement.setInt(1, entidade.getExameId().getId());
            statement.setInt(2, entidade.getComposicaoExameId().getId());
            statement.setInt(3, entidade.getValorReferenciaComposicaoExameId().getId());
            statement.setLong(4, entidade.getId());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
