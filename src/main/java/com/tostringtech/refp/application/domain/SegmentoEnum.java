package com.tostringtech.refp.application.domain;

public enum SegmentoEnum {
    GERACAO("G", "Geração"),
    TRANSMISSAO("T", "Transmissão"),
    DISTRIBUICAO("D", "Distribuição"),
    COMERCIALIZACAO("C", "Comercialização");

    String codigo;
    String segmento;

    SegmentoEnum(String codigo, String segmento) {
        this.codigo = codigo;
        this.segmento = segmento;
    }

    public String getCodigo() {
        return codigo;
    }



    public String getSegmento() {
        return segmento;
    }


}
