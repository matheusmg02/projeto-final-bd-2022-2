package br.com.frota.DAO;

import br.com.frota.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoHasLaboratorioDAO extends ConexaoDB{
    private static final String INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (responsavel_tecnico_id, laboratorio_id) VALUES (?, ?);";
    private static final String SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID = "SELECT id, responsavel_tecnico_id, laboratorio_id FROM medico WHERE laboratorio_id = ?";
    private static final String SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO = "SELECT * FROM responsavel_tecnico_id;";
    private static final String DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_id WHERE id = ?;";
    private static final String UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "UPDATE responsavel_tecnico_id SET responsavel_tecnico_id = ?, laboratorio_id = ? WHERE id = ?;";
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

    public void insertResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, entidade.getLaboratorioId().getId());
            preparedStatement.setInt(2, entidade.getResponsavelTecnicoId().getId());

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

    public ResponsavelTecnicoHasLaboratorio findById(int id) {
        ResponsavelTecnicoHasLaboratorio entidade = null;
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int laboratorioId = rs.getInt("laboratorio_id");
                Laboratorio laboratorio = new LaboratorioDAO().findById(laboratorioId);
                int responsavelTecnicoId = rs.getInt(laboratorioId);
                ResponsavelTecnico responsavelTecnico = new ResponsavelTecnicoDAO().findById(responsavelTecnicoId);
                entidade = new ResponsavelTecnicoHasLaboratorio(responsavelTecnico, laboratorio);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<ResponsavelTecnicoHasLaboratorio> selectAllMedicoHasEspecialidade() {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int laboratorioId = rs.getInt("laboratorio_id");
                Laboratorio laboratorio = new LaboratorioDAO().findById(laboratorioId);
                int responsavelTecnicoId = rs.getInt(laboratorioId);
                ResponsavelTecnico responsavelTecnico = new ResponsavelTecnicoDAO().findById(responsavelTecnicoId);


                entidades.add(new ResponsavelTecnicoHasLaboratorio(responsavelTecnico, laboratorio));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResponsavelTecnicoHasLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setInt(1, entidade.getLaboratorioId().getId());
            statement.setInt(2, entidade.getResponsavelTecnicoId().getId());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}