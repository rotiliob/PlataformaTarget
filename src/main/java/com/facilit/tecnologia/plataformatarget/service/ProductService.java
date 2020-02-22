package com.facilit.tecnologia.plataformatarget.service;

import com.facilit.tecnologia.plataformatarget.domain.Product;
import com.facilit.tecnologia.plataformatarget.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> findPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> finById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
