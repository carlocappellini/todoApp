package com.spring.angular.todoapp.repositories;


import com.spring.angular.todoapp.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepositories extends MongoRepository<Todo, String> {
}
