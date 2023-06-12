package shop.productservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shop.productservice.model.Attribute;
import shop.productservice.model.Category;
import shop.productservice.model.Product;
import shop.productservice.repository.ProductRepository;
import shop.productservice.service.IProductService;
import shop.productservice.service.adapters.ProductDTOAdapter;
import shop.productservice.service.dto.NewProductDTO;

import java.util.List;
import java.util.Optional;
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
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = true)
    public Page<Product> listProducts(int pageNumber, int pageSize) {
        Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException()
        );
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
    }

    public Product updateProduct(Product product) {//+ change status
        Optional<Product> storedProductOptional = productRepository.findById(product.getId());
        Product storedProduct;
        
        if(storedProductOptional.isPresent()) {
            storedProduct = storedProductOptional.get();
            product.setCreatedDateTime(storedProduct.getCreatedDateTime());
            return productRepository.save(product);
        } else throw new EntityNotFoundException();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException()
        );

        productRepository.delete(product);
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
