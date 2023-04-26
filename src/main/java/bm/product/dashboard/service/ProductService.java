package bm.product.dashboard.service;
import bm.product.dashboard.model.Client;
import bm.product.dashboard.model.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import bm.product.dashboard.model.Product;
import bm.product.dashboard.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product getProductById(Integer product_id) {
        return productRepository.getProductById(product_id);
    }
    public Map<String,Object> countAllUsers(){
        List<Product> products=productRepository.findAll();
        Integer sum=0;
        Map <String,Integer> userNumber =new HashMap<>();
        Map<String,Object> sumOfUsers= new HashMap<>();
        for(Product product: products){
            userNumber.put(product.getProduct_name(), product.getNo_of_users());
            sum+=product.getNo_of_users();

        }
        sumOfUsers.put("No-of-Users",userNumber);
        sumOfUsers.put("SumOfUsers",sum);
        return(sumOfUsers);
    }
    public List<Client> findAllClients() {
        List<Product> products = productRepository.findAll();
        List<Client> clients = new ArrayList<>();
        for(Product product:products){
            clients.addAll(product.getClient());

        }
        return(clients);
    }

    public Map<String, Object> getProductRevenueById(Integer product_id) {
        Product product = productRepository.getProductById(product_id);
        List<Revenue> revenue = product.getRevenue();
        Integer sum=0;
        for(Revenue revenue1: revenue){
           sum+=revenue1.getProduct_revenue();
        }

        Map<String,Object> map = new HashMap<>();
        map.put("product_name",product.getProduct_name());
        map.put("totalRevenue",sum);
        map.put("Revenue",revenue);
        return map;
    }


    public Map<String, Object> getClientByProductId(Integer product_id) {
        Product product = productRepository.getProductById(product_id);
        List<Client> clients = product.getClient();
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",product.getProduct_name());
        map.put("clients",clients);
        return map;
    }

    public Map<String, Object> getDescriptionByProductId(Integer product_id) {
        Product product = productRepository.getProductById(product_id);
        String desc = product.getProduct_desc();
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",product.getProduct_name());
        map.put("description",desc);
        return map;
    }

    public Map<String, Object> getUsersByProductId(Integer product_id) {
        Product product = productRepository.getProductById(product_id);
        Integer user = product.getNo_of_users();
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",product.getProduct_name());
        map.put("no_of_users",user);
        return map;
    }

    public Map<String, Object> getCountriesByProductId(Integer product_id) {
        Product product = productRepository.getProductById(product_id);
        List<String> countries = product.getCountry();
        Map<String,Object> map = new HashMap<>();
        map.put("product_name",product.getProduct_name());
        map.put("countries",countries);
        return map;
    }
}

