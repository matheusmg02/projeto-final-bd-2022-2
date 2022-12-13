package br.com.frota.model;

public class HabilitacaoExame extends GenericModel{
    private String observacao;
    private Double custo;
    private Laboratorio laboratorioId;
    private TipoExame tipoExameId;

    public HabilitacaoExame(int id, String observacao, Double custo, Laboratorio laboratorioId, TipoExame tipoExameId) {
        this.setId(id);
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
    }

    public HabilitacaoExame(String observacao, Double custo, Laboratorio laboratorioId, TipoExame tipoExameId) {
        super();
        this.observacao = observacao;
        this.custo = custo;
        this.laboratorioId = laboratorioId;
        this.tipoExameId = tipoExameId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Laboratorio getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(Laboratorio laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public TipoExame getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(TipoExame tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    @Override
    public String toString() {
        return "Habilitacao_exame{" +
                "observacao='" + observacao + '\'' +
                ", custo=" + custo +
                ", laboratorio_id=" + laboratorioId +
                ", tipo_exame_id=" + tipoExameId +
                '}';
    }
}
