package com.salao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonManagedReference
    private Cliente cliente;

    private Integer formaPagamento; //aula 22 parte1 prof nelioalves. Recurso para guardar o Enum em um integer.
    private BigDecimal valorTotal;

    @JsonIgnore
    @OneToMany(mappedBy="id.comanda", fetch = FetchType.EAGER)
    private Set<ServicoRealizado> servicosRealizados = new HashSet<>(); // set pq nao vai ter o mesmo servico realizado mais de uma vez na mesa comanda

    public Comanda(LocalDateTime data, Cliente cliente, FormaPagamento formaPagamento, BigDecimal valorTotal) {
        this.data = data;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento.getCod();
        this.valorTotal = valorTotal;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento.getCod();
    }

    public FormaPagamento getFormaPagamento() {
        return FormaPagamento.toEnum(formaPagamento);
    }

    //@JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
