package com.facilit.tecnologia.plataformatarget.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AFFILIATE")
public class Affiliate {

    @Id
    @Column(name = "COUPON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUPON_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @ManyToMany(mappedBy = "affiliates", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Coupon> coupons = new HashSet<>();
}
