package com.itc.clientapi.clientApi.entity;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.itc.clientapi.clientApi.custom_annotations.UniqueClientId;
import com.itc.clientapi.clientApi.custom_annotations.UniqueMobileNumber;

public class Client {
	
	@Id
	@NotEmpty
	@UniqueClientId
	private String clientId;
	
	@NotBlank(message="FirstName is mandatory")
	private String firstName;
	private String lastName;
	
	@NotBlank(message="Mobile number is mandatory")
	@UniqueMobileNumber
	private String mobno;
	
	private String physicalAddress;
	

	public Client(String clientId, String firstName, String lastName, String mobno, String physicalAddress) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobno = mobno;
		this.physicalAddress = physicalAddress;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobno() {
		return mobno;
	}


	public void setMobno(String mobno) {
		this.mobno = mobno;
	}


	public String getPhysicalAddress() {
		return physicalAddress;
	}


	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	
	@Override
	public String toString() {
		return String.format("Client[id=%s,firstname=%s,lastName=%s,mobilenumber=%s,Address=%s]",clientId,firstName,lastName,mobno,physicalAddress);
	}
	
}
