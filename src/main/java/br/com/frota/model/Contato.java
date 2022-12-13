package br.com.frota.model;

public class Contato extends GenericModel{
    private String telefone;
    private Laboratorio laboratorioId;

    public Contato(int id,String telefone, Laboratorio laboratorioId) {
        this.setId(id);
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;
    }

    public Contato(String telefone, Laboratorio laboratorioId) {
        super();
        this.telefone = telefone;
        this.laboratorioId = laboratorioId;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Laboratorio getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "telefone='" + telefone + '\'' +
                ", laboratorio_id=" + laboratorioId +
                '}';
    }
}
