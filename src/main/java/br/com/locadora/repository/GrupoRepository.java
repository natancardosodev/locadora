/**
 * 
 */
package br.com.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;


/**
 * @author cbarbosag
 *
 */
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

	List<Grupo> findByUsuariosIn(Usuario usuario);
	
	@Query(value = " SELECT g.* FROM usuario_grupos ug INNER JOIN usuario u ON ug.usuarios_id = u.id" + 
				   " INNER JOIN grupo g ON ug.grupos_id = g.id" + 
				   " WHERE u.id = :idUsuario",  nativeQuery=true)
	List<Grupo> listaGrupoPorIdUsuario(@Param("idUsuario") Long idUsuario);
}
