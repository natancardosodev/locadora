package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.locadora.model.Cliente;
import br.com.locadora.repository.ClienteRepository;
import br.com.locadora.repository.filtros.FiltroUsuario;

/**
 * @author natancardosodev
 *
 */

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public Cliente findOne(Long id) {
		return this.clienteRepository.findOne(id);
	}
	
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void remove(Long id) {
		this.clienteRepository.delete(id);
	}
	
	public List<Cliente> findByNome(FiltroUsuario filtro){
		String filtroNome = filtro.getNome() == null ? "%" : filtro.getNome();
		return  this.clienteRepository.findByNomeContaining(filtroNome);
	}

}