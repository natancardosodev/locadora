/**
 * 
 */
package br.com.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Permissao;


/**
 * @author cbarbosag
 *
 */
@Repository
public interface PermissaoRepository extends JpaRepository<br.com.locadora.model.Permissao, Long> {

	List<Permissao> findByGruposIn(Grupo grupo);
}
