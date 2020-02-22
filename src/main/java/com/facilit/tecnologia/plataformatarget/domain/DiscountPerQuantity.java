package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DiscountPerQuantity extends Discount{


    @Override
    public Cart applyDiscount(Cart cart) {
        cart.getCartProducts().forEach(productCart -> {
            if(productCart.getQuantity() >= 10){
                productCart.setAmountOfDiscount(0.01);
            }
        });

        return cart;
    }
}
