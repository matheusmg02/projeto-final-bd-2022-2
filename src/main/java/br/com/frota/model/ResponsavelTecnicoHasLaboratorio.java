package br.com.frota.model;

public class ResponsavelTecnicoHasLaboratorio extends GenericModel{
    private ResponsavelTecnico responsavelTecnicoId;
    private Laboratorio laboratorioId;

    public ResponsavelTecnicoHasLaboratorio(ResponsavelTecnico responsavelTecnicoId, Laboratorio laboratorioId) {
        this.responsavelTecnicoId = responsavelTecnicoId;
        this.laboratorioId = laboratorioId;
    }

    public ResponsavelTecnico getResponsavelTecnicoId() {
        return responsavelTecnicoId;
    }

    public void setResponsavelTecnicoId(ResponsavelTecnico responsavelTecnicoId) {
        this.responsavelTecnicoId = responsavelTecnicoId;
    }

    public Laboratorio getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    @Override
    public String toString() {
        return "Responsavel_tecnico_has_laboratorio{" +
                "responsavel_tecnico_id=" + responsavelTecnicoId +
                ", laboratorio_id=" + laboratorioId +
                '}';
    }
}
