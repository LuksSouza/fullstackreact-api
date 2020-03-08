package com.in28minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllBy(String username) {
        return repository.findAllByUsername(username);
    }

    public Todo getByUsernameAndId(String username, Long id) {
        return repository.findByUsernameAndId(username, id);
    }

    public Todo deleteByUsernameAndId(String username, Long id) {
        Todo todo = this.getByUsernameAndId(username, id);

        if (todo == null) {
            return null;
        }

        repository.delete(todo);

        return todo;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

}
