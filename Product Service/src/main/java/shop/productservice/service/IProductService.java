package shop.productservice.service;

import shop.productservice.model.Product;
import shop.productservice.model.Attribute;
import shop.productservice.model.Category;
import shop.productservice.service.dto.NewProductDTO;

import java.util.List;

public interface IProductService {
    public List<Product> listProducts();
    public NewProductDTO saveProduct(NewProductDTO newProductDTO);
    public Product updateProduct(Product product);//+ change status
    public Product deleteProduct(Product product);
    public List<Product> listProductsByCategory(Category category);
    public List<Product> searchProducts(String queryString);
    public List<Product> filterProducts(List<Attribute> attributes);
}
