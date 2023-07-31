package com.examly.springapp.payload;

public class CustomerDto {

    private int customerId;
	private String name;
    private String email;
    private String phone;
    
    
    
    public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public CustomerDto(int customerId, String name, String email, String phone) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

    
}
