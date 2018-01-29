/**
 * 
 */
package br.com.locadora.controller;

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

import br.com.locadora.model.Cliente;
import br.com.locadora.repository.filtros.FiltroUsuario;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.GrupoService;


/**
 * @author natancardosodev
 *
 */
@Controller
public class ClienteController {
	
	public static String CADASTRAR_CLIENTES = "/clientes/addClientes";
	
	public static String LISTAR_CLIENTES = "/clientes/clientes";
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private GrupoService grupoService;
	
	
	
	@GetMapping("/clientes")
	public ModelAndView findAll(@ModelAttribute("filtro") FiltroUsuario filtro) {		
		ModelAndView mv = new ModelAndView(LISTAR_CLIENTES);
		List<Cliente> clientes = this.clienteService.findByNome(filtro);
		mv.addObject("clientes", clientes);
		return mv;
	}

	@GetMapping("/addClientes")
	public ModelAndView add(Cliente cliente) {
		ModelAndView mv = new ModelAndView(CADASTRAR_CLIENTES);
		mv.addObject("cliente", cliente);
		mv.addObject("grupos", this.grupoService.listAll());
		return mv;
	}

	@GetMapping("/editClientes/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(clienteService.findOne(id));
	}

	@GetMapping("/deleteClientes/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
		ModelAndView mvRedirect = new ModelAndView("redirect:/clientes");
		clienteService.remove(id);
		attributes.addFlashAttribute("sucesso", "Cliente removido com sucesso!");
		return mvRedirect;
	}
	

	@PostMapping("/saveClientes")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new  ModelAndView(CADASTRAR_CLIENTES);
		
		if (result.hasErrors()) {
			return mv;
		}
		
		clienteService.save(cliente);
		ModelAndView mvRedirect = new  ModelAndView("redirect:/clientes");
		attributes.addFlashAttribute("sucesso", "Cliente adicionado com sucesso!");
		return mvRedirect;
	}
	
	
//	@GetMapping("/ativar/{id}")
//	public ModelAndView ativar(@PathVariable("id") Long id, RedirectAttributes attributes) {
//		ModelAndView mvRedirect = new  ModelAndView("redirect:/usuarios");
//		Cliente u = this.clienteService.findOne(id);
//		if(u.isAtivo()) {
//			this.clienteService.ativaDesativaUsuario(this.clienteService.findOne(id));
//		}else {
//			this.clienteService.ativaDesativaUsuario(this.clienteService.findOne(id));
//		}
//		return mvRedirect;
//	}
	
}
