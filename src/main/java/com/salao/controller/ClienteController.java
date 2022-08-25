package com.salao.controller;

import com.salao.entity.Cliente;
import com.salao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
