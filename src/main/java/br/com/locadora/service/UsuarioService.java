/**
 * 
 */
package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.UsuarioRepository;
import br.com.locadora.repository.filtros.FiltroUsuario;


/**
 * @author cbarbosag
 * Classe de serviço de usuário.
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario findOne(Long id) {
		return this.usuarioRepository.findOne(id);
	}
	
	public Usuario save(Usuario usuario) {
		String senha = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senha);
		return this.usuarioRepository.save(usuario);
	}
	
	public void remove(Long id) {
		this.usuarioRepository.delete(id);
	}
	
	public List<Usuario> findByNome(FiltroUsuario filtro){
		String filtroNome = filtro.getNome() == null ? "%" : filtro.getNome();
		return  this.usuarioRepository.findByNomeContaining(filtroNome);
	}
	
	public void ativaDesativaUsuario(Usuario usuario) {
		
		if(usuario.isAtivo()) {
			usuario.setAtivo(false);
		}else {
			usuario.setAtivo(true);
		}
		
		this.usuarioRepository.saveAndFlush(usuario);
	}
	
	public Usuario findByLogin(String login) {
		return this.usuarioRepository.findByLogin(login);
	}
}
