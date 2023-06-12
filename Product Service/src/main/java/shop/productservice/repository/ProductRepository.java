package shop.productservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.productservice.model.Product;

import java.awt.print.Pageable;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    Page<Product> findAll(Pageable pageable);
}
