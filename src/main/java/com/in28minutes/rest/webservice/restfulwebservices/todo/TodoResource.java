package com.in28minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users/{username}/todos")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getAllBy(@PathVariable String username) {
        return service.getAllBy(username);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Todo> getByUsernameAndId(@PathVariable String username, @PathVariable Long id) {

        Todo todo = service.getByUsernameAndId(username, id);

        if (todo == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteByUsernameAndId(@PathVariable String username, @PathVariable Long id) {
        Todo todo = service.deleteByUsernameAndId(username, id);

        if (todo != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id, @RequestBody Todo todo) {
        Todo todoUpdated = service.save(todo);

        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo todoCreated = service.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(todoCreated.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}
