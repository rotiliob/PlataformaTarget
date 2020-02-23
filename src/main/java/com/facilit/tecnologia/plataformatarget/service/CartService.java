package com.facilit.tecnologia.plataformatarget.service;

import com.facilit.tecnologia.plataformatarget.domain.Cart;
import com.facilit.tecnologia.plataformatarget.domain.Product;
import com.facilit.tecnologia.plataformatarget.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart create(Cart cart){
        if(cart == null){
            throw new RuntimeException("O carro o está inválido");
        }
        return cartRepository.save(cart);
    }

    public void addProduct(Long productId, Long cartId) {
        final Optional<Product> product = productService.finById(productId);
        final Optional<Cart> cart = cartRepository.findById(cartId);
        try {
            if (cart.isPresent() && product.isPresent()) {
                cart.get().addProduct(product.get());
                cartRepository.save(cart.get());
            }
        } catch (Exception ex) {
            throw new RuntimeException("O carro ou o produto está inválido",ex.getCause());
        }
    }

    public Optional<Cart> findById(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            return cart;
        }
        throw new RuntimeException("Id do carro invalido");
    }
}

