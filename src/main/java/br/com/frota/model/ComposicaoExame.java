package br.com.frota.model;

public class ComposicaoExame extends GenericModel{
    private String descricao;

    private UnidadeMedida unidadeMedidaId;

    public ComposicaoExame(int id, String descricao, UnidadeMedida unidadeMedidaId) {
        this.setId(id);
        this.descricao = descricao;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public ComposicaoExame(String descricao, UnidadeMedida unidadeMedidaId) {
        super();
        this.descricao = descricao;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeMedida getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(UnidadeMedida unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    @Override
    public String toString() {
        return "Marca [descricao=" + descricao + ", unidade_medida_id=" + unidadeMedidaId + "]";
    }
}