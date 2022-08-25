package com.salao.services;

import com.salao.entity.ServicoRealizado;
import com.salao.repositories.ServicoRealizadoRepository;
import com.salao.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoRealizadoService {

    @Autowired
    private ServicoRealizadoRepository servicoRealizadoRepository;

    public List<ServicoRealizado> getAllServicoRealizados() {

        return servicoRealizadoRepository.findAll();
    }

    public ServicoRealizado getServicoRealizado(Long id) {

        if (servicoRealizadoRepository.findById(id).isEmpty()) {

            throw new ObjectNotFoundException("Id do servicoRealizado nao encontrado! Id: " + id + ", Tipo:"
                    + ServicoRealizado.class.getName());
        }

        return servicoRealizadoRepository.findById(id).get();
    }
}
