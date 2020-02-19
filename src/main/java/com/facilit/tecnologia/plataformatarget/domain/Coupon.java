package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @Column(name = "COUPON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Cart> carts = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "AFFILIATE_COUPON", joinColumns = {@JoinColumn(name = "COUPON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AFFILIATE_ID")})
    private Set<Affiliate> affiliates = new HashSet<>();

}
