package br.com.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByNomeContaining(String filtro);
	
	Usuario findByLogin(String login);
}
