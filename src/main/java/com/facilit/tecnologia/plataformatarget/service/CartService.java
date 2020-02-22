package com.facilit.tecnologia.plataformatarget.service;

import com.facilit.tecnologia.plataformatarget.domain.Cart;
import com.facilit.tecnologia.plataformatarget.domain.Product;
import com.facilit.tecnologia.plataformatarget.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addProduct(Set<Product> product, Cart cart) {
        try {
            if (cart != null && product != null) {
                cart.setProducts(product);
                return cartRepository.save(cart);
            }
        } catch (Exception ex) {
            ex.getCause();
        }
        return null;
    }
}

