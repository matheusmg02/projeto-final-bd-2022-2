package br.com.frota.DAO;

import br.com.frota.model.Especialidade;
import br.com.frota.model.MaterialExame;
import br.com.frota.model.Medico;
import br.com.frota.model.MedicoHasEspecialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoHasEspecialidadeDAO extends ConexaoDB{
    private static final String INSERT_MEDICO_HAS_ESPECIALIDADE_SQL = "INSERT INTO medico_has_especialidade (medico_id, especialidade_id) VALUES (?, ?);";
    private static final String SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID = "SELECT medico_id, especialidade_id FROM medico_has_especialidade WHERE especialidade_id = ?";
    private static final String SELECT_ALL_MEDICO_HAS_RESPONSABILIDADE = "SELECT * FROM medico_has_especialidade;";
    private static final String DELETE_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE id = ?;";
    private static final String UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL = "UPDATE medico_has_especialidade SET medico_id = ? WHERE especialidade_id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medico_has_especialidade;";

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

    public void insertMedicoHasEspecialidade(MedicoHasEspecialidade entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICO_HAS_ESPECIALIDADE_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entidade.getMedicoId().getId());
            preparedStatement.setInt(2, entidade.getEspecialidadeId().getId());
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

    public MedicoHasEspecialidade findById(int id) {
        MedicoHasEspecialidade entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICO_HAS_ESPECIALIDADE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int medicoId = rs.getInt("material");
                Medico medico = new MedicoDAO().findById(medicoId);
                int especialidadeId = rs.getInt("observacacao");
                Especialidade especialidade = new EspecialidadeDAO().findById(especialidadeId);
                entidade = new MedicoHasEspecialidade(medico, especialidade);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MedicoHasEspecialidade> selectAllMaterialExame() {
        List<MedicoHasEspecialidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICO_HAS_RESPONSABILIDADE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int medicoId = rs.getInt("material");
                Medico medico = new MedicoDAO().findById(medicoId);
                int especialidadeId = rs.getInt("observacacao");
                Especialidade especialidade = new EspecialidadeDAO().findById(especialidadeId);
                entidades.add(new MedicoHasEspecialidade(medico, especialidade));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicoHasEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMedicoHasEspecialidade(MaterialExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
            statement.setString(1, entidade.getMaterial());
            statement.setString(2, entidade.getObservacao());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
