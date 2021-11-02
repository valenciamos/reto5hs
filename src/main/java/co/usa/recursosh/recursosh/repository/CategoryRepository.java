package co.usa.recursosh.recursosh.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.recursosh.recursosh.model.Category;
import co.usa.recursosh.recursosh.repository.crud.CategoryCrudRepository;


@Repository

public class CategoryRepository {

    @Autowired
    CategoryCrudRepository categoryCrudRepository;
    
    public List<Category>getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save (Category catg){
        return categoryCrudRepository.save(catg);
    }

    public void delete(Category catg){
        categoryCrudRepository.delete(catg);
    }

}
