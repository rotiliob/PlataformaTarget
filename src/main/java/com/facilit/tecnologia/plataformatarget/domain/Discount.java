package com.facilit.tecnologia.plataformatarget.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "PERCENT")
    Double percent;

    @Column(name = "NAME")
    String name;

    public abstract Cart applyDiscount(Cart cart);
}
