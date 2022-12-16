package br.com.frota.model;

public class MedicoHasEspecialidade extends GenericModel{
    private Medico medicoId;
    private Especialidade especialidadeId;

    public MedicoHasEspecialidade(Medico medicoId, Especialidade especialidadeId) {
        this.medicoId = medicoId;
        this.especialidadeId = especialidadeId;
    }


    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    public Especialidade getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Especialidade especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    @Override
    public String toString() {
        return "Medico_has_especialidade{" +
                "medico_id=" + medicoId +
                ", especialidade_id=" + especialidadeId +
                '}';
    }
}
