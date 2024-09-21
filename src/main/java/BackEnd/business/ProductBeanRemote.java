package BackEnd.business;

import BackEnd.repositories.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    public void addProduct(Product product);
    public List<Product> getProducts();
    public Product getProductById(int id);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
}
