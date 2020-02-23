package com.facilit.tecnologia.plataformatarget.controller;

import com.facilit.tecnologia.plataformatarget.domain.Cart;
import com.facilit.tecnologia.plataformatarget.service.CartService;
import com.facilit.tecnologia.plataformatarget.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/{cartId}/{productId}")
    public ResponseEntity<Cart> addProduct(@PathVariable Long productId, @PathVariable Long cartId) {
        cartService.addProduct(productId, cartId);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
