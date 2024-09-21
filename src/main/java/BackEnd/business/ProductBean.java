package BackEnd.business;

import BackEnd.repositories.entities.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ProductBean implements ProductBeanRemote {
    @PersistenceContext(unitName = "ProductPU")
    private EntityManager em;
    @Override
    public void addProduct(Product product) {
        try {
            em.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        return em.createNamedQuery("Product.findById", Product.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateProduct(Product product) {
        try {
            em.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            Product product = em.find(Product.class, id);
            em.remove(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
