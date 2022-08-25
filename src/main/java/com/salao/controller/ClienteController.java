package com.salao.controller;

import com.salao.entity.Cliente;
import com.salao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClients() {
        List<Cliente> allClientes = clienteService.getAllClientes();
        return ResponseEntity.ok(allClientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {

            Cliente cliente = clienteService.getCliente(id);
            return ResponseEntity.ok(cliente);

    }


}
