package shop.productservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        System.out.println("new request");
        return new ResponseEntity<List<Product>>(productService.listProducts(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody NewProductDTO newProductDTO) {
        System.out.println("new request1" + newProductDTO.toString());
        return new ResponseEntity<NewProductDTO>(productService.saveProduct(newProductDTO), HttpStatus.OK);
    }


}
