package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ProductCart {

    @Id
    @Column(name = "PRO_CAR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    private Integer quantity;

    private Double amountOfDiscount;

    /**
     * @param product
     */
    public ProductCart(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @param product
     */
    public ProductCart(Product product) {
        this(product, 1);
    }

    public double getTotalBeforeDiscount() {
                return quantity * this.product.getPrice();
    }
}
