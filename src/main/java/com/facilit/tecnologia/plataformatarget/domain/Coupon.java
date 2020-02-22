package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "COUPON")
public class Coupon extends Discount {


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "AFFILIATE_COUPON", joinColumns = {@JoinColumn(name = "COUPON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AFFILIATE_ID")})
    private Set<Affiliate> affiliates = new HashSet<>();


    @Override
    public Cart applyDiscount(Cart cart) {
        cart.setCoupon(this);
        cart.setDiscountValue(percent);
        return cart;
    }
}
