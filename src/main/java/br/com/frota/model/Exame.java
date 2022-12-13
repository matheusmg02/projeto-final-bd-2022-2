package br.com.frota.model;

public class Exame extends GenericModel{
    private TipoExame tipoExameId;
    private String descricao;
    private MaterialExame materialExameId;
    private String metodo;

    public Exame(int id, TipoExame tipoExameId, String descricao, MaterialExame materialExameId, String metodo) {
        this.setId(id);
        this.tipoExameId = tipoExameId;
        this.descricao = descricao;
        this.materialExameId = materialExameId;
        this.metodo = metodo;
    }

    public Exame(TipoExame tipoExameId, String descricao, MaterialExame materialExameId, String metodo) {
        super();
        this.tipoExameId = tipoExameId;
        this.descricao = descricao;
        this.materialExameId = materialExameId;
        this.metodo = metodo;
    }

    public TipoExame getTipoExameId() {
        return tipoExameId;
    }

    public void setTipoExameId(TipoExame tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MaterialExame getMaterialExameId() {
        return materialExameId;
    }

    public void setMaterialExameId(MaterialExame materialExameId) {
        this.materialExameId = materialExameId;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Exame{" +
                "tipo_exame_id=" + tipoExameId +
                ", descricao='" + descricao + '\'' +
                ", material_exame_id=" + materialExameId +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}
