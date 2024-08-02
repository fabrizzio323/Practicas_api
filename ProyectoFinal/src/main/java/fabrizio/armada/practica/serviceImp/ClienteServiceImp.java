package fabrizio.armada.practica.serviceImp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fabrizio.armada.practica.model.Cliente;
import fabrizio.armada.practica.repository.ClienteRepository;
import fabrizio.armada.practica.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}

	@Override
	public void createCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Cliente getCliente(Long id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
        Cliente cliente = new Cliente();
		if(clienteOp!=null) {
           cliente = clienteOp.get();
		}
		return cliente;
	}

	@Override
	public Cliente editCliente(Long id, Cliente nuevoCliente) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
        Cliente cliente = new Cliente();
		if(clienteOp.isPresent()) {
           cliente = clienteOp.get();
           if(nuevoCliente.getNombre()!= null ) cliente.setNombre(nuevoCliente.getNombre());
           if(nuevoCliente.getApellido()!= null) cliente.setApellido(nuevoCliente.getApellido());
           if(nuevoCliente.getDni()!= null) cliente.setDni(nuevoCliente.getDni());
           clienteRepository.save(cliente);
   		   return cliente;

		}else {
	        throw new NoSuchElementException("No se encontró el cliente con ID: " + id);

		}
	}

}
