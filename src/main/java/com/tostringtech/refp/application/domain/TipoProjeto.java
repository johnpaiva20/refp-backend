package com.tostringtech.refp.application.domain;

public enum TipoProjeto {
    PESQUISA_DESENVOLVIMENTO("PD", "Pesquisa e desenvolvimento"),
    EFICIENCIA_ENERGETICA("EE", "Eficiêcia Energética");

    String codigo;
    String tipo;

    TipoProjeto(String codigo, String tipo) {
        this.codigo=codigo;
        this.tipo=tipo;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public static TipoProjeto toEnum(String codigo) {

        if (codigo == null) {
            return null;
        }
        for (TipoProjeto tipo : TipoProjeto.values()) {
            if (codigo.equals(tipo.getCodigo())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("O código do tipo do projeto inválido: " + codigo);
    }
}
