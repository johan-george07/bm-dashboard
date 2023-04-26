package bm.product.dashboard.model;

public class Client {
    public String client_id;
    public String client_name;
    public Integer client_users;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public int getClient_users() {
        return client_users;
    }

    public void setClient_users(int client_users) {
        this.client_users = client_users;
    }
}

