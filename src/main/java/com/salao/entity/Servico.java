package com.salao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal valor;

    @JsonIgnore
    @OneToMany(mappedBy = "id.servico", fetch = FetchType.LAZY)
    private Set<ServicoRealizado> servicosRealizados = new HashSet<>(); //para dizer que o servico tambem conhece os servicos realizados relacionados a ele

    @JsonIgnore
    public List<Comanda> getComandas() {
        List<Comanda> lista = new ArrayList<>();
        for (ServicoRealizado x : servicosRealizados) {
            lista.add(x.getComanda());
        }
        return lista;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
