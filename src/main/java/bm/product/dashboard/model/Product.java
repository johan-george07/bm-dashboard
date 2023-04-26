package bm.product.dashboard.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("dashboard")
public class Product {
    
    private int product_id;
    private List<Client> client;
    private String product_name;
    private String product_desc;
    private int no_of_users;
    private List<String> country;
    private List<Revenue> revenue;

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public int getNo_of_users() {
        return no_of_users;
    }

    public void setNo_of_users(int no_of_users) {
        this.no_of_users = no_of_users;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<Revenue> getRevenue() {
        return revenue;
    }

    public void setRevenue(List<Revenue> revenue) {
        this.revenue = revenue;
    }
}

