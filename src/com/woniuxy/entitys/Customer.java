package com.woniuxy.entitys;

public class Customer {
	
	private int cusId;
	private String cusName;
	private String cusPwd;
	private String cusPhone;
	private String cusAdd;
	private String cusStaus;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int cusId, String cusName, String cusPwd, String cusPhone, String cusAdd, String cusStaus) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPwd = cusPwd;
		this.cusPhone = cusPhone;
		this.cusAdd = cusAdd;
		this.cusStaus = cusStaus;
	}


	
	
	



	public Customer(int cusId, String cusName, String cusPwd, String cusPhone, String cusAdd) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPwd = cusPwd;
		this.cusPhone = cusPhone;
		this.cusAdd = cusAdd;
	}


	public Customer(int cusId, String cusName, String cusPhone, String cusAdd) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusAdd = cusAdd;
	}


	public Customer(String cusName, String cusPwd, String cusPhone, String cusAdd) {
		super();
		this.cusName = cusName;
		this.cusPwd = cusPwd;
		this.cusPhone = cusPhone;
		this.cusAdd = cusAdd;
	}


	public Customer(String cusName, String cusPwd) {
		// TODO Auto-generated constructor stub
		super();
		this.cusName = cusName;
		this.cusPwd = cusPwd;
	}

	
	
	public Customer(String cusName, String cusPhone, String cusAdd) {
		super();
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusAdd = cusAdd;
	}


	public int getCusId() {
		return cusId;
	}


	public void setCusId(int cusId) {
		this.cusId = cusId;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public String getCusPwd() {
		return cusPwd;
	}


	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}


	public String getCusPhone() {
		return cusPhone;
	}


	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}


	public String getCusAdd() {
		return cusAdd;
	}


	public void setCusAdd(String cusAdd) {
		this.cusAdd = cusAdd;
	}


	public String getCusStaus() {
		return cusStaus;
	}


	public void setCusStaus(String cusStaus) {
		this.cusStaus = cusStaus;
	}


	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusPwd=" + cusPwd + ", cusPhone=" + cusPhone
				+ ", cusAdd=" + cusAdd + ", cusStaus=" + cusStaus + "]";
	}
	
	
	
	
	
}
