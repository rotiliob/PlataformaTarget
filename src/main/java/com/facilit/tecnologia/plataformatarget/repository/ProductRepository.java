package com.facilit.tecnologia.plataformatarget.repository;

import com.facilit.tecnologia.plataformatarget.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
