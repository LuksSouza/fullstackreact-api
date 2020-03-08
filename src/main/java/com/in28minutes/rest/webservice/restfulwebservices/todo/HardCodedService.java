package com.in28minutes.rest.webservice.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HardCodedService {

    private static Long counter = 0L;
    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo(++counter, "Lucas", "Learn React", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Redux", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn React Native", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn String Framework", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Spring Boot", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Spring Data", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Spring Security", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Docker", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn CI/CD", new Date(), false));
        todoList.add(new Todo(++counter, "Lucas", "Learn Jenkins", new Date(), false));
    }

    public List<Todo> getAllBy(String username) {
        return todoList;
    }

    public Todo deleteByUsernameAndId(String username, Long id) {
        Todo todo = getByUsernameAndId(username, id);

        if (todo == null) return null;

        if (todoList.remove(todo)) {
            return todo;
        }

        return null;
    }

    public Todo getByUsernameAndId(String username, Long id) {
        Optional<Todo> todoFound = todoList.stream().filter(todo -> todo.getId().equals(id)).findFirst();

        if (todoFound.isPresent()) {
            return todoFound.get();
        }

        return null;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++counter);
            todoList.add(todo);
        } else {
            this.deleteByUsernameAndId("", todo.getId());
            todoList.add(todo);
        }

        return todo;
    }

}
