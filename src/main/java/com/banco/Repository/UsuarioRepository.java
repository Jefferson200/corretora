package com.banco.Repository;

import org.springframework.data.repository.CrudRepository;

import com.banco.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	Usuario findByEmail(String email);
}
