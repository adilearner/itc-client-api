package com.itc.clientapi.clientApi.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Component;

import com.itc.clientapi.clientApi.entity.Client;

@Component
public class ClientDaoService {
	private static List<Client> clients=new ArrayList<Client>();
	private static int clientCount= 5;
	private static final String SAF_CONSTANT ="SAF";
	
	
	static {
		clients.add(new Client("SAF1","Virat","Kohli","987654321","Bangalore"));
		clients.add(new Client("SAF2","Rohit","Sharma","987894321","Mumbai"));
		clients.add(new Client("SAF3","Mahendra","Dhoni","893264321","Chennai"));
		clients.add(new Client("SAF4","Ajinkya","Rahane","987324113","Jaipur"));
		clients.add(new Client("SAF5","Shikhar","Dhawan","987654321","Delhi"));		
	}

	public Client save(Client client) {
		// TODO Auto-generated method stub
		if(client.getClientId()!=null) {
			client.setClientId(SAF_CONSTANT+(++clientCount));
		}
		clients.add(client);
		return client;
	}

	public Client findById(String clientId) {
		// TODO Auto-generated method stub
		for(Client client:clients) {
			if(client.getClientId().equals(clientId)) {
				return client;
			}
		}
		return null;
	}

	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clients;
	}

	public Client deleteById(String clientId) {
		// TODO Auto-generated method stub
		Iterator<Client> itr=clients.iterator();
		while(itr.hasNext()) {
			Client client=itr.next();
			if(client.getClientId().equals(clientId)) {
				itr.remove();
				return client;
			}
		}
		return null;
	}

		public Client findByPhone(String phoneNo) {
		// TODO Auto-generated method stub
				for(Client client:clients) {
					if(client.getMobno().equals(phoneNo)) {
						return client;
					}
				}
				return null;
	}

		public Client findByfirstName(int firstName) {
			// TODO Auto-generated method stub
			for(Client client:clients) {
				if(client.getFirstName().equals(firstName)) {
					return client;
				}
			}
			return null;
		}

		public boolean existsByMobNo(String mobNo) {
			// TODO Auto-generated method stub
			for(Client client:clients) {
				if(client.getMobno().equals(mobNo)) {
					return true;
				}
			}
			return false;
		}

		public boolean existsByClientId(String clientId) {
			// TODO Auto-generated method stub
			for(Client client:clients) {
				if(client.getClientId().equals(clientId) && !client.getClientId().startsWith(SAF_CONSTANT)) {
					return true;
				}
			}
			return false;
		}
		
		public boolean existsBySafId(String clientId) {
			// TODO Auto-generated method stub
			for(Client client:clients) {
				if(!client.getClientId().startsWith(SAF_CONSTANT)) {
					return true;
				}
			}
			return false;
		}
	

}
