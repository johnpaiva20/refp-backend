package com.tostringtech.refp.application.domain;

public enum CategoriaContabil {
    RECURSOS_HUMANOS("RH", "Recursos Humanos"),
    MATERIAIS_CONSUMO("MC", "Materiais de Consumo"),
    MATERIAIS_PERMANENTES_EQUIPAMENTOS("MP", "Materiais permanente e equipamentos"),
    SERVICOS_TERCEIROS("ST", "Serviços de terceiros"),
    VIAGENS_DIARIAS("VD", "Viagens e diárias"),
    OUTROS("OU", "Outros");

    private String codigo;
    private String categoria;

    private CategoriaContabil(String codigo, String categoria) {
        this.codigo = codigo;
        this.categoria = categoria;
    }

    public String getCod() {
        return codigo;
    }

    public String getDescricao() {
        return categoria;
    }

    public static CategoriaContabil toEnum(Integer codigo) {

        if (codigo == null) {
            return null;
        }
        for (CategoriaContabil rub : CategoriaContabil.values()) {
            if (codigo.equals(rub.getCod())) {
                return rub;
            }
        }
        throw new IllegalArgumentException("O código da categoria contábil inválido: " + codigo);
    }


}
