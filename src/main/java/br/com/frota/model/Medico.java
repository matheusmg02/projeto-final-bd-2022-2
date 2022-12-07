package br.com.frota.model;

public class Medico extends GenericModel{
    private String crm;
    private String pessoa;

    public Medico(int id, String crm, String pessoa) {
        this.setId(id);
        this.crm = crm;
        this.pessoa = pessoa;
    }

    public Medico(String crm, String pessoa) {
        super();
        this.crm = crm;
        this.pessoa = pessoa;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", pessoa='" + pessoa + '\'' +
                '}';
    }
}
