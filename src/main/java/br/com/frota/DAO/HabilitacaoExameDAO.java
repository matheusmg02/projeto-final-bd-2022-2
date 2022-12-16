package br.com.frota.DAO;

import br.com.frota.model.Exame;
import br.com.frota.model.HabilitacaoExame;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.TipoExame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilitacaoExameDAO extends ConexaoDB{
    private static final String INSERT_HABILITACAO_EXAME_SQL = "INSERT INTO exame (tipo_exame_id, descricao, material_exame_id, metodo) VALUES (?, ?, ?, ?);";
    private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT id, tipo_exame, descricao, material_exame_id, metodo FROM exame WHERE id = ?";
    private static final String SELECT_ALL_HABILITACAO_EXAME = "SELECT * FROM exame;";
    private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM exame WHERE id = ?;";
    private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE exame SET tipo_exame_id = ?, descricao = ?, material_exame_id = ?, metodo = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM especialidade;";

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

    public void insertHabilitacaoExame(HabilitacaoExame entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_HABILITACAO_EXAME_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setDouble(2, entidade.getCusto());
            preparedStatement.setInt(3, entidade.getLaboratorioId().getId());
            preparedStatement.setInt(4, entidade.getTipoExameId().getId());

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

    public HabilitacaoExame findById(int id) {
        HabilitacaoExame entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_HABILITACAO_EXAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Double custo = rs.getDouble("custo");
                int laboratorioId = rs.getInt("laboratorio_id");
                Laboratorio lab = new LaboratorioDAO().findById(laboratorioId);
                int tipoExameId = rs.getInt("tipo_exame_id");
                TipoExame tipoExam = new TipoExameDAO().findById(tipoExameId);
                entidade = new HabilitacaoExame(id, observacao, custo, lab, tipoExam);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<HabilitacaoExame> selectAllExame() {
        List<HabilitacaoExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_HABILITACAO_EXAME)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Double custo = rs.getDouble("custo");
                int laboratorioId = rs.getInt("laboratorio_id");
                Laboratorio lab = new LaboratorioDAO().findById(laboratorioId);
                int tipoExameId = rs.getInt("tipo_exame_id");
                TipoExame tipoExam = new TipoExameDAO().findById(tipoExameId);
                entidades.add(new HabilitacaoExame(id, observacao, custo, lab, tipoExam));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteHabilitacaoExame(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_HABILITACAO_EXAME_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateHabilitacaoExame(HabilitacaoExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_HABILITACAO_EXAME_SQL)) {

            statement.setString(1, entidade.getObservacao());
            statement.setDouble(2, entidade.getCusto());
            statement.setInt(3, entidade.getLaboratorioId().getId());
            statement.setInt(4, entidade.getTipoExameId().getId());
            statement.setInt(5, entidade.getId());


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
