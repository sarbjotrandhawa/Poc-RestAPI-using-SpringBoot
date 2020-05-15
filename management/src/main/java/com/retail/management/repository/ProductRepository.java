package com.retail.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.retail.management.entity.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Product p WHERE barcode = :barcode")
    boolean isProductExists(String barcode);
}
