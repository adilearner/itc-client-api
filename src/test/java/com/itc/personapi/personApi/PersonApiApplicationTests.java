package com.itc.personapi.personApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.itc.clientapi.clientApi.ClientApiApplication;
import com.itc.clientapi.clientApi.dao.ClientDaoService;
import com.itc.clientapi.clientApi.entity.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ClientApiApplication.class)
class PersonApiApplicationTests {

	@Autowired
	ClientDaoService service;
	
	@Test
	public void findByClientId_test() {
		Client client=service.findById("SAF1");
		assertEquals("987654321", client.getMobno());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test() {
		service.deleteById("SAF4");
		assertNull(service.findById("SAF4"));
	}
	
	@Test
	@DirtiesContext
	public void createClient_test() {
		//Get a client
		Client client = service.findById("SAF3");
		assertEquals("Dhoni", client.getLastName());
		//update details
		client.setLastName("Singh Dhoni");
		service.save(client);
		
		//check the value
		Client client1=service.findById("SAF3");
		assertEquals("Singh Dhoni", client.getLastName());
	}
	

}
