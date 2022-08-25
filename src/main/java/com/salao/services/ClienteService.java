package com.salao.services;

import com.salao.entity.Cliente;
import com.salao.services.exception.ObjectNotFoundException;
import com.salao.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {

        return clienteRepository.findAll();
    }

    public Cliente getCliente(Long id) {

        if (clienteRepository.findById(id).isEmpty()) {

            throw new ObjectNotFoundException("Id do cliente nao encontrado! Id: " + id + ", Tipo:"
                    + Cliente.class.getName());
        }

        return clienteRepository.findById(id).get();
    }
}
