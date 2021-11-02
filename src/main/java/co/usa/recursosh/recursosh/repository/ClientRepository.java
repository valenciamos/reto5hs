package co.usa.recursosh.recursosh.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.recursosh.recursosh.model.Client;
import co.usa.recursosh.recursosh.repository.crud.ClientCrudRepository;


@Repository
public class ClientRepository {

    @Autowired

    private ClientCrudRepository clienteCrudRepositorio;

    public List<Client> getAll(){
        return (List<Client>)clienteCrudRepositorio.findAll();       
    }

    public Optional<Client>getCliente(int id){
        return clienteCrudRepositorio.findById(id);       
    }
    
    public Client save(Client cliente){
        return clienteCrudRepositorio.save(cliente);
    }
    
    public void delete(Client cliente){
         clienteCrudRepositorio.delete(cliente);
    }
                 
            
}       
   
    

