package co.usa.recursosh.recursosh.repository;

import co.usa.recursosh.recursosh.model.Client;

public class CountClient {
    private Long total;
    private Client client;
    
    public CountClient(Long total, Client client2) {
        this.total = total;
        this.client = client2;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
