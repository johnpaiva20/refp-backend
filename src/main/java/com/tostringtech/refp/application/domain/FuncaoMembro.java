package com.tostringtech.refp.application.domain;

public enum FuncaoMembro {
    COORDENADOR("CO", "Coordenador"),
    GERENTE("GE", "Gerente"),
    PESQUISADOR("PE", "Pesquisador"),
    AUXILIAR_TECNICO("AT", "Auxiliar Técnico"),
    AUXILIAR_TECNICO_BOLSISTA("AB", "Auxiliar Técnico Bolsista"),
    AUXILIAR_ADMINISTRATIVO("AA", "Auxiliar Administrativo");

    FuncaoMembro(String codigo, String funcao) {
    }
}
