package com.salao.services;

import com.salao.entity.Comanda;
import com.salao.repositories.ComandaRepository;
import com.salao.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> getAllComandas() {
        return comandaRepository.findAll();
    }

    public Comanda getComanda(Long id) {

        if (comandaRepository.findById(id).isEmpty()) {

            throw new ObjectNotFoundException("Id do comanda nao encontrado! Id: " + id + ", Tipo:"
                    + Comanda.class.getName());
        }

        return comandaRepository.findById(id).get();
    }
}
