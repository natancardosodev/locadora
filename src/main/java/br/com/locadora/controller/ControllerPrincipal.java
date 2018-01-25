/**
 * 
 */
package br.com.locadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cbarbosag
 * Controlle que abre a tela principal do sistema.
 */
@Controller
public class ControllerPrincipal {
	
	@RequestMapping("/")
	public String index() {
		return "template/principal";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "template/dashboard";
	}
}
