package BackEnd.api;

import BackEnd.business.ProductBeanRemote;
import BackEnd.repositories.entities.Product;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBean;

    @GET
    public Response getAll() {
        return Response.ok(productBean.getProducts()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(productBean.getProductById(id)).build();
    }

    @POST
    public Response create(Product product) {
        productBean.addProduct(product);
        return Response.ok(product).build();
    }
}
