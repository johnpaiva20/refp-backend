package com.tostringtech.refp.projeto.api.rest.enums;

public enum FaseInovacaoEnum {

    PESQUISA_BASICA_DIRIGIDA("PB", "Pesquisa Básica Dirigida"),
    PESQUISA_APLICADA("PA", "Pesquisa Aplicada"),
    DESENVOLVIMENTO_EXPERIMENTAL("DE", "Desenvolvimento Experimental"),
    CABECA_DE_SERIE("CS", "Cabeça-de-série"),
    LOTE_PIONEIRO("LP", "Lote Pioneiro"),
    INSERCAO_MERCADO("IM", "Inserção no Mercado");

    private String codigo;
    private String fase;

    FaseInovacaoEnum(String codigo, String fase) {
        this.codigo = codigo;
        this.fase = fase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
