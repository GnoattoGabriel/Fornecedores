package com.gnoatto.Fornecedores.services;


import com.gnoatto.Fornecedores.models.FornecedorModel;
import com.gnoatto.Fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {


    @Autowired
    private FornecedorRepository fornecedorRepository;


    public FornecedorModel criarForn(FornecedorModel novoForn){
        return fornecedorRepository.save(novoForn);
    }

    public List<FornecedorModel> listarTodos(){
        return fornecedorRepository.findAll();
    }

    public void deletarForn(Long id){
        fornecedorRepository.deleteById(id);
    }

    public Optional<FornecedorModel> buscarPorId(Long id){
        return fornecedorRepository.findById(id);
    }

    public FornecedorModel atualizarForn(Long id, FornecedorModel novoForn){
        Optional<FornecedorModel> fornNobanco = fornecedorRepository.findById(id);

        if(fornNobanco.isPresent()){
            FornecedorModel fornEditar = fornNobanco.get();

            fornEditar.setNomeFantasia(novoForn.getNomeFantasia());
            fornEditar.setCnpj(novoForn.getCnpj());
            fornEditar.setContato(novoForn.getContato());

            return fornecedorRepository.save(fornEditar);

        } else return null;

    }


}
