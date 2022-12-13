package br.com.frota.model;

public class ResponsavelTecnico extends GenericModel{
    private String nome;
    private String conselho;
    private String formacao;
    private String siglaFormacao;
    private SiglaFormacao siglaFormacaoId;

    public ResponsavelTecnico(int id, String nome, String conselho, String formacao, String siglaFormacao, SiglaFormacao siglaFormacaoId) {
        this.setId(id);
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
        this.siglaFormacaoId = siglaFormacaoId;
    }

    public ResponsavelTecnico(String nome, String conselho, String formacao, String siglaFormacao, SiglaFormacao siglaFormacaoId) {
        super();
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
        this.siglaFormacaoId = siglaFormacaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getSiglaFormacao() {
        return siglaFormacao;
    }

    public void setSiglaFormacao(String siglaFormacao) {
        this.siglaFormacao = siglaFormacao;
    }

    public SiglaFormacao getSiglaFormacaoId() {
        return siglaFormacaoId;
    }

    public void setSiglaFormacaoId(SiglaFormacao siglaFormacaoId) {
        this.siglaFormacaoId = siglaFormacaoId;
    }

    @Override
    public String toString() {
        return "Responsavel_tecnico{" +
                "nome='" + nome + '\'' +
                ", conselho='" + conselho + '\'' +
                ", formacao='" + formacao + '\'' +
                ", sigla_formacao='" + siglaFormacao + '\'' +
                ", sigla_formacao_id=" + siglaFormacaoId +
                '}';
    }
}
