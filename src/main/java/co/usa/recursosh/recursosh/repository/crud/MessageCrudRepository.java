package co.usa.recursosh.recursosh.repository.crud;

import org.springframework.data.repository.CrudRepository;
import co.usa.recursosh.recursosh.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {

    
}
