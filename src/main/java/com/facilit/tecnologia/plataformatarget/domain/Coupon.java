package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @Column(name = "COUPON_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Cart> carts = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "AFFILIATE_COUPON", joinColumns = {@JoinColumn(name = "COUPON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AFFILIATE_ID")})
    private Set<Affiliate> affiliates = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id) &&
                Objects.equals(name, coupon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
