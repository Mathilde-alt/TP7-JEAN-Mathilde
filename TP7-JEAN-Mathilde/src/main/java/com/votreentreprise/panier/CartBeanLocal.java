package com.votreentreprise.panier;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CartBeanLocal {
    void addProductToCart(Product product);
    void checkOut();
    public List<Product> getCartItems();
	void removeProduct(String productId);
}
