package com.tostringtech.refp.projeto.api.rest.enums;

public enum TipoProjetoEnum {
    PESQUISA_DESENVOLVIMENTO("PD", "Pesquisa e desenvolvimento"),
    EFICIENCIA_ENERGETICA("EE", "Eficiêcia Energética");

    String codigo;
    String tipo;

    TipoProjetoEnum(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public static TipoProjetoEnum toEnum(String codigo) {

        if (codigo == null) {
            return null;
        }
        for (TipoProjetoEnum tipo : TipoProjetoEnum.values()) {
            if (codigo.equals(tipo.getCodigo())) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("O código do tipo do projeto inválido: " + codigo);
    }
}
