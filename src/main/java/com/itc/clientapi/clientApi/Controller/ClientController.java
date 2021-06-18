package com.itc.clientapi.clientApi.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itc.clientapi.clientApi.Exception.ClientNotFoundException;
import com.itc.clientapi.clientApi.dao.ClientDaoService;
import com.itc.clientapi.clientApi.entity.Client;

@RestController
@RequestMapping("/client-api")
public class ClientController {

	@Autowired
	private ClientDaoService service;
	
	@GetMapping("/clients")
	public List<Client> getAllClient(){
		return service.findAll();
	}
	
	@GetMapping("/client/clientId/{clientId}")
	public Client retrieveClientById(@PathVariable String clientId) {
		
		Client client = service.findById(clientId);
		if(client == null)
		{
			throw new ClientNotFoundException("ClientId-"+clientId);
		}
		return client;
	}
	
	@GetMapping("/client/phoneNo/{phoneNo}")
	public Client retrieveClientByPhone(@PathVariable String phoneNo) {
		
		Client client = service.findByPhone(phoneNo);
		if(client == null)
		{
			throw new ClientNotFoundException("Client Not Found with phoneNo -"+phoneNo);
		}
		return client;
	}
	
	@GetMapping("/client/firstName/{firstName}")
	public Client retrieveClientByFirstName(@PathVariable int firstName) {
		
		Client client = service.findByfirstName(firstName);
		if(client == null)
		{
			throw new ClientNotFoundException("Client Not Found with firstName -"+firstName);
		}
		return client;
	}
	
	
	@PostMapping("/clients")
	public ResponseEntity<Object> createClient(@Valid @RequestBody Client client){
		
		Client savedClient= service.save(client);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{clientId}")
						.buildAndExpand(savedClient.getClientId()).toUri();
		
		return ResponseEntity.created(location).build();	
	}
	
	@DeleteMapping("/clients/{clientId}")
	public void deleteClient(@PathVariable String clientId) 
	{
		Client client=service.deleteById(clientId);
		if(client == null) {
			throw new ClientNotFoundException("Client not deleted with Id-"+clientId);			
		}
	}
	
	
}
