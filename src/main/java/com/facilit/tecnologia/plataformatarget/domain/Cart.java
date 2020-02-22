package com.facilit.tecnologia.plataformatarget.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_ID")
    private Long id;

    @Column(name = "PRODUCT_QUANTITY")
    private int productQuantity;

    @Column(name = "QUANTITY_PER_PRODUCT")
    private int quantityPerProduct;

    @Column(name = "DISCOUNT")
    private Double discount;

    @Column(name = "AMOUNT")
    private Double amount;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    private Coupon coupon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return productQuantity == cart.productQuantity &&
                quantityPerProduct == cart.quantityPerProduct &&
                Objects.equals(id, cart.id) &&
                Objects.equals(discount, cart.discount) &&
                Objects.equals(amount, cart.amount) &&
                Objects.equals(coupon, cart.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productQuantity, quantityPerProduct, discount, amount, coupon);
    }
}
