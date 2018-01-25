/**
 * 
 */
package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Permissao;
import br.com.locadora.repository.PermissaoRepository;


/**
 * @author cbarbosag
 * Classe de serviço de usuário.
 */
@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public List<Permissao> findByGruposIn(Grupo grupo){
		return this.permissaoRepository.findByGruposIn(grupo);
	}

}
