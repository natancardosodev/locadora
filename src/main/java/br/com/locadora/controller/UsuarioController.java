/**
 * 
 */
package br.com.locadora.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.locadora.model.Grupo;
import br.com.locadora.model.Usuario;
import br.com.locadora.repository.filtros.FiltroUsuario;
import br.com.locadora.service.GrupoService;
import br.com.locadora.service.UsuarioService;


/**
 * @author cbarbosag
 *
 */
@Controller
public class UsuarioController {
	
	public static String CADASTRAR_USUARIOS = "/usuarios/addUsuarios";
	
	public static String LISTAR_USUARIOS = "/usuarios/usuarios";
	
	@Autowired
	private UsuarioService usuarioServer;
	
	@Autowired
	private GrupoService grupoService;
	
	
	
	@GetMapping("/usuarios")
	public ModelAndView findAll(@ModelAttribute("filtro") FiltroUsuario filtro) {		
		ModelAndView mv = new ModelAndView(LISTAR_USUARIOS);
		List<Usuario> usuarios = this.usuarioServer.findByNome(filtro);
		mv.addObject("usuarios", usuarios);
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		ModelAndView mv = new ModelAndView(CADASTRAR_USUARIOS);
		mv.addObject("usuario", usuario);
		mv.addObject("grupos", this.grupoService.listAll());
		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(usuarioServer.findOne(id));
	}
	
	@GetMapping("/showPermissao/{id}")
	public ModelAndView permissaoUsuario(@PathVariable("id") Long idUsuario) {
		ModelAndView mv = new  ModelAndView();
		List<Grupo> gruposUsuario = this.grupoService.listaGrupoPorIdUsuario(idUsuario);
		mv.addObject("gruposUsuario", gruposUsuario);
		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mvRedirect = new  ModelAndView("redirect:/usuarios");
		usuarioServer.remove(id);
		attributes.addFlashAttribute("sucesso", "Usuário removido com sucesso!");
		return mvRedirect;
	}
	

	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new  ModelAndView(CADASTRAR_USUARIOS);
		
		if (result.hasErrors()) {
			return mv;
		}
		
		usuarioServer.save(usuario);
		ModelAndView mvRedirect = new  ModelAndView("redirect:/usuarios");
		attributes.addFlashAttribute("sucesso", "Usuário adicionado com sucesso!");
		return mvRedirect;
	}
	
	
	@GetMapping("/ativar/{id}")
	public ModelAndView ativar(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mvRedirect = new  ModelAndView("redirect:/usuarios");
		Usuario u = this.usuarioServer.findOne(id);
		if(u.isAtivo()) {
			this.usuarioServer.ativaDesativaUsuario(this.usuarioServer.findOne(id));
		}else {
			this.usuarioServer.ativaDesativaUsuario(this.usuarioServer.findOne(id));
		}
		return mvRedirect;
	}
	
}





















