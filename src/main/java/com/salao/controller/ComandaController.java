package com.salao.controller;

import com.salao.entity.Comanda;
import com.salao.services.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comanda")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @GetMapping
    public ResponseEntity<List<Comanda>> getAllClients() {
        List<Comanda> allComandas = comandaService.getAllComandas();
        return ResponseEntity.ok(allComandas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comanda> getComanda(@PathVariable Long id) {

            Comanda comanda = comandaService.getComanda(id);
            return ResponseEntity.ok(comanda);

    }


}
