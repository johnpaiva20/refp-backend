package com.tostringtech.refp.projeto.core.enums;

public enum TipoProjetoEnum {
    PESQUISA_DESENVOLVIMENTO("PD", "Pesquisa e Desenvolvimento"),
    EFICIENCIA_ENERGETICA("EE", "Eficiêcia Energética");

    String codigo;
    String descricao;

    TipoProjetoEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
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
