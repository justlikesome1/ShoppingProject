package com.woniuxy.entitys;

import java.util.Date;

public class Shoppings {
	private int shoppingId;
	private int goodsId;
	private int cusId;
	private int shoppingCount;
	private Date shoppingTime;
	private Goods goods;
	
	
	public Shoppings() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Shoppings(int shoppingId, int goodsId, int cusId, int shoppingCount, Date shoppingTime) {
		super();
		this.shoppingId = shoppingId;
		this.goodsId = goodsId;
		this.cusId = cusId;
		this.shoppingCount = shoppingCount;
		this.shoppingTime = shoppingTime;
	}

	
	

	public Shoppings(int goodsId, int cusId) {
		super();
		this.goodsId = goodsId;
		this.cusId = cusId;
	}


	public Shoppings(int shoppingId, int goodsId, int cusId, int shoppingCount, Date shoppingTime, Goods goods) {
		super();
		this.shoppingId = shoppingId;
		this.goodsId = goodsId;
		this.cusId = cusId;
		this.shoppingCount = shoppingCount;
		this.shoppingTime = shoppingTime;
		this.goods = goods;
	}


	public int getShoppingId() {
		return shoppingId;
	}


	public void setShoppingId(int shoppingId) {
		this.shoppingId = shoppingId;
	}


	public int getGoodsId() {
		return goodsId;
	}


	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}


	public int getCusId() {
		return cusId;
	}


	public void setCusId(int cusId) {
		this.cusId = cusId;
	}


	public int getShoppingCount() {
		return shoppingCount;
	}


	public void setShoppingCount(int shoppingCount) {
		this.shoppingCount = shoppingCount;
	}


	public Date getShoppingTime() {
		return shoppingTime;
	}


	public void setShoppingTime(Date shoppingTime) {
		this.shoppingTime = shoppingTime;
	}

	
	

	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	@Override
	public String toString() {
		return "Shoppings [shoppingId=" + shoppingId + ", goodsId=" + goodsId + ", cusId=" + cusId + ", shoppingCount="
				+ shoppingCount + ", shoppingTime=" + shoppingTime + "]";
	}
	
	
	
	
	
}
