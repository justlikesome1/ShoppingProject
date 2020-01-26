package com.woniuxy.entitys;

import java.util.Date;

public class Orders {
	private int orders_id;
	private int cusId;
	private Date ordersTime;
	private float ordersPrice;
	private String ordersStatus;
	private String ordersRemark;
	private String ordersAdd;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orders_id, int cusId, Date ordersTime, String ordersStatus, String ordersRemark) {
		super();
		this.orders_id = orders_id;
		this.cusId = cusId;
		this.ordersTime = ordersTime;
		this.ordersStatus = ordersStatus;
		this.ordersRemark = ordersRemark;
	}

	public Orders(int orders_id, int cusId, Date ordersTime, float ordersPrice, String ordersStatus,
			String ordersRemark) {
		super();
		this.orders_id = orders_id;
		this.cusId = cusId;
		this.ordersTime = ordersTime;
		this.ordersPrice = ordersPrice;
		this.ordersStatus = ordersStatus;
		this.ordersRemark = ordersRemark;
	}

	public Orders(int cusId, Date ordersTime, String ordersStatus, String ordersRemark) {
		super();
		this.cusId = cusId;
		this.ordersTime = ordersTime;
		this.ordersStatus = ordersStatus;
		this.ordersRemark = ordersRemark;
	}
	
	

	public Orders(int cusId, float ordersPrice, String ordersRemark, String ordersAdd) {
		super();
		this.cusId = cusId;
		this.ordersPrice = ordersPrice;
		this.ordersRemark = ordersRemark;
		this.ordersAdd = ordersAdd;
	}

	public Orders(int cusId, float ordersPrice,String ordersRemark) {
		super();
		this.cusId = cusId;
		this.ordersPrice = ordersPrice;
		this.ordersRemark = ordersRemark;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public Date getOrdersTime() {
		return ordersTime;
	}

	public void setOrdersTime(Date ordersTime) {
		this.ordersTime = ordersTime;
	}

	public String getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public String getOrdersRemark() {
		return ordersRemark;
	}

	public void setOrdersRemark(String ordersRemark) {
		this.ordersRemark = ordersRemark;
	}
	
	
	
	
	public String getOrdersAdd() {
		return ordersAdd;
	}

	public void setOrdersAdd(String ordersAdd) {
		this.ordersAdd = ordersAdd;
	}

	public float getOrdersPrice() {
		return ordersPrice;
	}

	public void setOrdersPrice(float ordersPrice) {
		this.ordersPrice = ordersPrice;
	}

	@Override
	public String toString() {
		return "Orders [orders_id=" + orders_id + ", cusId=" + cusId + ", ordersTime=" + ordersTime + ", ordersPrice="
				+ ordersPrice + ", ordersStatus=" + ordersStatus + ", ordersRemark=" + ordersRemark + ", ordersAdd="
				+ ordersAdd + "]";
	}


	
	
	
	
}
