package com.lucaslira.produtoscadastro.store.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "products")
public class ProductsBean {
	
	private ProductBean selectedProduct;
	private List<ProductBean> products;
	
	public ProductsBean() {
		products = new ArrayList<>();
		selectedProduct = new ProductBean();
	}
	
	public List<ProductBean> getProducts() {
		return products;
	}
	
	public void add(ProductBean product) {		
		products.add(product);
	}
	
	public void remove(ProductBean product) {
		products.remove(product);
	}
	
	public String select(ProductBean product) {
		selectedProduct = product;

		return "productDetail";
	}
	
	public ProductBean getSelectedProduct() {
		return selectedProduct;
	}

}
