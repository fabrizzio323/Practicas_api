package fabrizio.armada.practica.service;

import java.util.List;

import fabrizio.armada.practica.model.Cliente;

public interface ClienteService {
        
	   public List<Cliente> getAllClientes();
	   public void createCliente(Cliente cliente);
	   public void deleteCliente(Long id);
	   public Cliente getCliente(Long id);
	   public Cliente editCliente(Long id, Cliente nuevoCliente);
}
