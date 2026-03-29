package com.gnoatto.Fornecedores.controllers;


import com.gnoatto.Fornecedores.models.FornecedorModel;
import com.gnoatto.Fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody FornecedorModel novoForn){
        FornecedorModel fornecedor = fornecedorService.criarForn(novoForn);
        return ResponseEntity.status(201).body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> buscarTodos(){
        return ResponseEntity.ok(fornecedorService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarForn(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorModel> atualizarFornecedor(@PathVariable Long id,@RequestBody FornecedorModel novoForn){
        FornecedorModel fornecedor = fornecedorService.atualizarForn(id, novoForn);
        return ResponseEntity.ok(fornecedor);
    }

}
