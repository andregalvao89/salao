package com.salao.services;

import com.salao.entity.Profissional;
import com.salao.repositories.ProfissionalRepository;
import com.salao.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<Profissional> getAllProfissionals() {

        return profissionalRepository.findAll();
    }

    public Profissional getProfissional(Long id) {

        if (profissionalRepository.findById(id).isEmpty()) {

            throw new ObjectNotFoundException("Id do profissional nao encontrado! Id: " + id + ", Tipo:"
                    + Profissional.class.getName());
        }

        return profissionalRepository.findById(id).get();
    }
}
