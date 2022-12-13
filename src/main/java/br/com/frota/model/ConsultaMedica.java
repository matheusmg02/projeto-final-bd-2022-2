package br.com.frota.model;

import java.util.Date;

public class ConsultaMedica extends GenericModel{
    private Medico medicoId;
    private Paciente pacienteId;

    private Date dtConsulta;
    private String nomeAtendimento;

    public ConsultaMedica(int id, Medico medicoId, Paciente pacienteId, Date dtConsulta, String nomeAtendimento) {
        this.setId(id);
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.dtConsulta = dtConsulta;
        this.nomeAtendimento = nomeAtendimento;
    }

    public ConsultaMedica(Medico medicoId, Paciente pacienteId, Date dtConsulta, String nomeAtendimento) {
        super();
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.dtConsulta = dtConsulta;
        this.nomeAtendimento = nomeAtendimento;
    }

    public Medico getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Medico medicoId) {
        this.medicoId = medicoId;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public String getNomeAtendimento() {
        return nomeAtendimento;
    }

    public void setNomeAtendimento(String nomeAtendimento) {
        this.nomeAtendimento = nomeAtendimento;
    }

    @Override
    public String toString() {
        return "Consulta_medica{" +
                "medico_id=" + medicoId +
                ", paciente_id=" + pacienteId +
                ", dt_consulta=" + dtConsulta +
                ", nome_atendimento='" + nomeAtendimento + '\'' +
                '}';
    }
}
