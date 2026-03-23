package com.gnoatto.Fornecedores.repositories;

import com.gnoatto.Fornecedores.models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
