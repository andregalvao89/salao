package com.salao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicoRealizado implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    //@JsonManagedReference
    //@JsonBackReference
    @EmbeddedId
    private ServicoRealizadoPK id = new ServicoRealizadoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    public ServicoRealizado(Comanda comanda, Servico servico, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setServico(servico);
        id.setComanda(comanda);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Comanda getComanda() {
        return id.getComanda();
    }

    public void setServico(Servico servico) {
        id.setServico(servico);
    }

    //@JsonIgnore
    public Servico getServico() {
        return id.getServico();
    }

}
