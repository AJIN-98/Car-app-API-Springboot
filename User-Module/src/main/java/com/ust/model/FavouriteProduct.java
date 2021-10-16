package com.ust.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FavouriteProduct {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="product-id")
private int productId;
@Column(name="product-name")
private String productName;
@Column(name="status")
private String productStatus;


public FavouriteProduct(int productId, String productName, String productStatus) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productStatus = productStatus;
}


public int getProductId() {
	return productId;
}


public void setProductId(int productId) {
	this.productId = productId;
}


public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}


public String getProductStatus() {
	return productStatus;
}


public void setProductStatus(String productStatus) {
	this.productStatus = productStatus;
}


}
