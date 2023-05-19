package shop.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.productservice.model.Attribute;
import shop.productservice.model.Category;
import shop.productservice.model.Product;
import shop.productservice.repository.ProductRepository;
import shop.productservice.service.IProductService;
import shop.productservice.service.adapters.ProductDTOAdapter;
import shop.productservice.service.dto.NewProductDTO;
import shop.productservice.service.impl.AttributeService;
import shop.productservice.service.impl.CategoryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;
    private AttributeService attributeService;
    private CategoryService categoryService;

    @Autowired
    public ProductService(
            ProductRepository productRepository,
            AttributeService attributeService,
            CategoryService categoryService) {

        this.productRepository = productRepository;
        this.attributeService = attributeService;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> listProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public NewProductDTO saveProduct(NewProductDTO newProductDTO) {
        Product product = ProductDTOAdapter.getProduct(newProductDTO);

        product.setAttributes(product.getAttributes().stream().map(attribute -> {
            return attributeService.getAttributeByName(attribute.getName()) != null ? attributeService.getAttributeByName(attribute.getName()) : attribute;
        }).collect(Collectors.toList()));


        product.setCategories(product.getCategories().stream().map( category -> {
            return categoryService.getCategoryByName(category.getName()) != null ? categoryService.getCategoryByName(category.getName()) : category;
        }).collect(Collectors.toList()));

        return ProductDTOAdapter.getProductDTO(productRepository.save(product));
//        return productRepository.save(product);
    }

    public Product updateProduct(Product product)//+ change status
    {
        return null;
    }

    public Product deleteProduct(Product product) {
        return null;
    }

    public List<Product> listProductsByCategory(Category category) {
        return null;
    }

    public List<Product> searchProducts(String queryString) {
        return null;
    }

    public List<Product> filterProducts(List<Attribute> attributes) {
        return null;
    }
}
