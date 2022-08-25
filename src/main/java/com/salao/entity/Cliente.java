package com.salao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    @OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
    @JsonBackReference //as comandas de clientes nao vao ser serializados
    private List<Comanda> comandas;
}
