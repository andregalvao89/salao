package com.salao.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ServicoRealizadoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="comanda_id")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name="servico_id")
    private Servico servico;
}
