package com.facilit.tecnologia.plataformatarget.repository;

import com.facilit.tecnologia.plataformatarget.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
