package FrontEnd.models;

import BackEnd.repositories.entities.Product;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class ProductModel {

    public void createProduct(Product product) {
        Client client = ClientBuilder.newClient();
            client.target("http://localhost:8080/BackEnd/api/products")
                    .request()
                    .post(jakarta.ws.rs.client.Entity.json(product));

    }

//    public Product[] getProducts() {
//        try(Client client = ClientBuilder.newClient();) {
//            return client.target("http://localhost:8080/BackEnd/api/products")
//                    .request()
//                    .get(Product[].class);
//        }
//    }
//
//    public Product getProductById(int id) {
//        try(Client client = ClientBuilder.newClient();) {
//            return client.target("http://localhost:8080/BackEnd/api/products/" + id)
//                    .request()
//                    .get(Product.class);
//        }
//    }
}
