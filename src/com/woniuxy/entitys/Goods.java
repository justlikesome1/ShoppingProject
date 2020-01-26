package com.woniuxy.entitys;

public class Goods {
	
	private int goodsId;
	private int supplierId;
	private int typeId;
	private String goodsCode;
	private String goodsName;
	private int goodsCount;
	private float goodsPrice;
	private String goodsImg;
	private String supplierName;
	private String typeName;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(int goodsId, int supplierId, int typeId, String goodsCode, String goodsName, int goodsCount,
			float goodsPrice, String goodsImg) {
		super();
		this.goodsId = goodsId;
		this.supplierId = supplierId;
		this.typeId = typeId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsCount = goodsCount;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
	}

	
	
	
	
	public Goods(String goodsName, int goodsCount, float goodsPrice, String goodsImg) {
		super();
		this.goodsName = goodsName;
		this.goodsCount = goodsCount;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
	}

	public Goods(int goodsId, String goodsCode, String goodsName, int goodsCount, float goodsPrice, String goodsImg,
			String supplierName, String typeName) {
		super();
		this.goodsId = goodsId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsCount = goodsCount;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
		this.supplierName = supplierName;
		this.typeName = typeName;
	}

	public Goods(int supplierId, int typeId, String goodsCode, String goodsName, float goodsPrice, String goodsImg) {
		super();
		this.supplierId = supplierId;
		this.typeId = typeId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
	}
	

	public Goods(int goodsId, int supplierId, int typeId, String goodsCode, String goodsName, float goodsPrice,
			String goodsImg) {
		super();
		this.goodsId = goodsId;
		this.supplierId = supplierId;
		this.typeId = typeId;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	
	
	

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", supplierId=" + supplierId + ", typeId=" + typeId + ", goodsCode="
				+ goodsCode + ", goodsName=" + goodsName + ", goodsCount=" + goodsCount + ", goodsPrice=" + goodsPrice
				+ ", goodsImg=" + goodsImg + "]";
	}
	
	
	
	
}
