package br.com.frota.DAO;

import br.com.frota.model.MaterialExame;
import br.com.frota.model.Medico;
import br.com.frota.model.MedicoHasEspecialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoHasResponsabilidadeDAO extends ConexaoDB{
    private static final String INSERT_MEDICO_HAS_RESPONSABILIDADE_SQL = "INSERT INTO medico_has_responsabilidade (medico_id, especialidade_id) VALUES (?, ?);";
    private static final String SELECT_MEDICO_HAS_RESPONSABILIDADE_BY_ID = "SELECT medico_id, especialidade_id FROM medico WHERE especialidade_id = ?";
    private static final String SELECT_ALL_MEDICO_HAS_RESPONSABILIDADE_ = "SELECT * FROM medico_has_responsabilidade;";
    private static final String DELETE_MEDICO_HAS_RESPONSABILIDADE_SQL = "DELETE FROM medico WHERE id = ?;";
    private static final String UPDATE_MEDICO_HAS_RESPONSABILIDADE_SQL = "UPDATE material_exame SET nome = ?, crm = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medico;";

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

    public void insertMedicoHasResponsabilidade(MedicoHasEspecialidade entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICO_HAS_RESPONSABILIDADE_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entidade.getMedicoId());
            preparedStatement.setInt(2, entidade.getEspecialidadeId());

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
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICO_HAS_RESPONSABILIDADE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String material = rs.getString("material");
                String observacao = rs.getString("observacacao");

                entidade = new MedicoHasEspecialidade(medicoId, especialidade_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<MaterialExame> selectAllMaterialExame() {
        List<MaterialExame> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String material = rs.getString("material");
                String observacao = rs.getString("observacacao");


                entidades.add(new MaterialExame(id, material, observacao));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDICO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateMaterialExame(MaterialExame entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDICO_SQL)) {

            statement.setString(1, entidade.getMaterial());
            statement.setString(2, entidade.getObservacao());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
