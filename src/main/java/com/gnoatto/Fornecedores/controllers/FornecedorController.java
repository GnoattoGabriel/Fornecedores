package com.gnoatto.Fornecedores.controllers;


import com.gnoatto.Fornecedores.models.FornecedorModel;
import com.gnoatto.Fornecedores.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public FornecedorModel criarFornecedor(@RequestBody FornecedorModel novoForn){
        return fornecedorService.criarForn(novoForn);
    }

    @GetMapping
    public List<FornecedorModel> buscarTodos(){
        return fornecedorService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarForn(id);
    }

    @GetMapping("/{id}")
    public Optional<FornecedorModel> buscarPorId(@PathVariable Long id){
        return fornecedorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public FornecedorModel atualizarFornecedor(@PathVariable Long id,@RequestBody FornecedorModel novoForn){
        return fornecedorService.atualizarForn(id, novoForn);
    }

}
