package com.banco.Repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.models.Conta;
import com.banco.models.Usuario;

public interface ContaRepository extends CrudRepository<Conta, String> {
	Conta findByCpf(String cpf);
	Conta findByCnpj(String cnpj);
}
