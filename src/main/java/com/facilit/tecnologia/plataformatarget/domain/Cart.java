package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
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
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    private Coupon coupon;
}
