package com.in28minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByUsername(String username);

    Todo findByUsernameAndId(String username, Long id);
}
