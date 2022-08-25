package com.salao.services;

import com.salao.entity.Servico;
import com.salao.repositories.ServicoRepository;
import com.salao.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> getAllServicos() {

        return servicoRepository.findAll();
    }

    public Servico getServico(Long id) {

        if (servicoRepository.findById(id).isEmpty()) {

            throw new ObjectNotFoundException("Id do servico nao encontrado! Id: " + id + ", Tipo:"
                    + Servico.class.getName());
        }

        return servicoRepository.findById(id).get();
    }
}
