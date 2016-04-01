package org.tony.spring.rest.example;

public class Greeting {
	
	private final Long id;
	
	private final String contant;
	
	public Greeting(Long id,String contant){
		this.id = id;
		this.contant = contant;
	}

	public Long getId() {
		return id;
	}

	public String getContant() {
		return contant;
	}
	
	

}
