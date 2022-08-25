package com.salao.entity;

import lombok.Getter;


@Getter
public enum FormaPagamento {

    DINHEIRO(1, "Dinheiro"),
    PIX(2, "PIX"),
    CARTAO_DEBITO(3, "Cartão de débito"),
    CARTAO_CREDITO(4, "Cartão de crétito");

    private int cod;
    private String descricao;

    FormaPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static FormaPagamento toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }
        for (FormaPagamento x : FormaPagamento.values()) {

            if (cod.equals(x.getCod())){
                return x;
            }

        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }
}
