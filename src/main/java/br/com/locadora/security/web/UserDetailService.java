/**
 * 
 */
package br.com.locadora.security.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Permissao;
import br.com.locadora.model.Usuario;
import br.com.locadora.service.GrupoService;
import br.com.locadora.service.PermissaoService;
import br.com.locadora.service.UsuarioService;

/**
 * @author cbarbosag
 *
 */
@Component
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private GrupoService grupoService;

	@Autowired
	private PermissaoService permissaoService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.findByLogin(username);

		if (usuario == null || usuario.isAtivo()) {
			throw new UsernameNotFoundException("Usuário Não encontrado!");
		}

		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
	}

	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return authorities(grupoService.findByUsuariosIn(usuario));
	}

	public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		Collection<GrantedAuthority> auths = new ArrayList<>();

		for (Grupo grupo : grupos) {
			List<Permissao> lista = permissaoService.findByGruposIn(grupo);

			for (Permissao permissao : lista) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
			}
		}

		return auths;
	}

}
