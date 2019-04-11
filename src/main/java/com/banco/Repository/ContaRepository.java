package com.banco.Repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.models.Conta;

public interface ContaRepository extends CrudRepository<Conta, String> {

}
