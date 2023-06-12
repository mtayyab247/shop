package shop.productservice.service;

import org.springframework.data.domain.Page;
import shop.productservice.model.Product;
import shop.productservice.model.Attribute;
import shop.productservice.model.Category;
import shop.productservice.service.dto.NewProductDTO;

import java.util.List;

public interface IProductService {
    public Page<Product> listProducts(int pageNumber, int pageSize);
    public Product getProductById(Integer id);
    public NewProductDTO saveProduct(NewProductDTO newProductDTO);
    public Product updateProduct(Product product);//+ change status
    public void deleteProduct(Integer id);
    public List<Product> listProductsByCategory(Category category);
    public List<Product> searchProducts(String queryString);
    public List<Product> filterProducts(List<Attribute> attributes);
}
