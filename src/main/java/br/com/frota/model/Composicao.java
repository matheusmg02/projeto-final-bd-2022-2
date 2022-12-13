package br.com.frota.model;

public class Composicao extends GenericModel{
    private Exame exameId;
    private ComposicaoExame composicaoExameId;
    private ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId;

    public Composicao(int id, Exame exameId, ComposicaoExame composicaoExameId, ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId) {
        this.setId(id);
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    public Composicao(Exame exameId, ComposicaoExame composicaoExameId, ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId) {
        super();
        this.exameId = exameId;
        this.composicaoExameId = composicaoExameId;
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    public Exame getExameId() {
        return exameId;
    }

    public void setExameId(Exame exameId) {
        this.exameId = exameId;
    }

    public ComposicaoExame getComposicaoExameId() {
        return composicaoExameId;
    }

    public void setComposicaoExameId(ComposicaoExame composicaoExameId) {
        this.composicaoExameId = composicaoExameId;
    }

    public ValorReferenciaComposicaoExame getValorReferenciaComposicaoExameId() {
        return valorReferenciaComposicaoExameId;
    }

    public void setValorReferenciaComposicaoExameId(ValorReferenciaComposicaoExame valorReferenciaComposicaoExameId) {
        this.valorReferenciaComposicaoExameId = valorReferenciaComposicaoExameId;
    }

    @Override
    public String toString() {
        return "Composicao [exame_id=" + exameId + ", composicao_exame_id=" + composicaoExameId + ", valor_referencia_composicao_exame_id=" + valorReferenciaComposicaoExameId;
    }
}