package shop.productservice.controller;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import shop.productservice.model.Product;
import shop.productservice.service.impl.ProductService;
import shop.productservice.service.dto.NewProductDTO;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<?> listProducts() {
        return new ResponseEntity<List<Product>>(productService.listProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
        } catch(EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id=%d not found!", id), exception);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody NewProductDTO newProductDTO) {
        return new ResponseEntity<NewProductDTO>(productService.saveProduct(newProductDTO), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        try {
            return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
        } catch(EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This product don't exists!", exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id=%d not found!", id), exception);
        }
    }
}
