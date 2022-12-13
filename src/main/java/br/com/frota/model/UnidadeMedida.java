package br.com.frota.model;

public class UnidadeMedida extends GenericModel{
    private String descricao;


    public UnidadeMedida(int id, String descricao){
        this.setId(id);
        this.descricao = descricao;
    }

    public UnidadeMedida(String descricao) {
        super();
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "UnidadeMedida{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}