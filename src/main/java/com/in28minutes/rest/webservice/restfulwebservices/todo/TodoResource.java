package com.in28minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private HardCodedService hardCodedService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllBy(@PathVariable String username) {
        return hardCodedService.getAllTodo();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deteleById(@PathVariable String username, @PathVariable Long id) {
        Todo todo = hardCodedService.deleteById(id);

        if (todo != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
