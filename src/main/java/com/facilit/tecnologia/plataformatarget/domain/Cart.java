package com.facilit.tecnologia.plataformatarget.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DISCOUNT")
    private Double discountValue;

    @Column(name = "AMOUNT")
    private Double amount;

    @OneToMany(mappedBy = "cart")
    private List<ProductCart> cartProducts = new ArrayList<>();

    @ManyToOne
    private Discount coupon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return                 Objects.equals(id, cart.id) &&
                Objects.equals(discountValue, cart.discountValue) &&
                Objects.equals(amount, cart.amount) &&
                Objects.equals(coupon, cart.coupon);
    }

    public Cart addProduct(Product product){

        getCartProducts().forEach(productCart -> {
            if(productCart.getProduct().equals(product)){
                int qtd = productCart.getQuantity() +1;
                productCart.setQuantity(qtd);
            }else{
                getCartProducts().add(new ProductCart(product));
            }
        });
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discountValue, amount, coupon);
    }
}
