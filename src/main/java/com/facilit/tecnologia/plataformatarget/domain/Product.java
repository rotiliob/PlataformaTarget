package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    private Long id;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CART")
    @ManyToOne
    @JoinTable(name = "CART_ID")
    private Cart cart;

}
