/**
 * 
 */
package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.GrupoRepository;


/**
 * @author cbarbosag
 * Classe de serviço de usuário.
 */
@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;
	
	public List<Grupo> findByUsuariosIn(Usuario usuario){
		
		return grupoRepository.findByUsuariosIn(usuario);
	}
	
	public List<Grupo> listAll(){
		return this.grupoRepository.findAll();
	}
	
	public List<Grupo> listaGrupoPorIdUsuario(Long idUsuario){
		return this.grupoRepository.listaGrupoPorIdUsuario(idUsuario);
	}
}
