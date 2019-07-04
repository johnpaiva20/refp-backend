package com.tostringtech.refp.projeto.api.domain;

public enum ProdutoEnum {

    CONCEITO_METODOLOGIA("CM", "Conceito ou Metodologia"),
    SOFTWARE("SW", "Software"),
    SISTEMA("SM", "Sistema"),
    MATERIAL_SUBSTANCIA("MS", "Material ou Substância"),
    COMPONENTE_DISPOSITIVO("CD", "Componente ou Dispositivo"),
    MAQUINA_EQUIPAMENTO("ME", "Máquina ou Equipamento");

    private String codigo;
    private String produto;


    ProdutoEnum(String codigo, String produto) {
        this.codigo = codigo;
        this.produto = produto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
