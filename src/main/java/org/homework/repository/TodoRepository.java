package org.homework.repository;

import org.homework.domain.Todo;
import org.homework.func.IDGenerator;

import java.util.ArrayList;
import java.util.Optional;

public class TodoRepository {
    private final ArrayList<Todo> todos = new ArrayList<>();
    private final IDGenerator idGenerator;

    public TodoRepository(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public int addTodo(Todo todo) {
        int newTodoId = idGenerator.generateTodoId();
        todo.setId(newTodoId);
        todos.add(todo);

        return newTodoId;
    }

    public Optional<Todo> getTodoById(int todoId) {
        return todos.stream()
                .filter(todo -> todo.getId() == todoId)
                .findFirst();
    }

    public void deleteTodoById(int todoId) {
        todos.removeIf(todo -> todo.getId() == todoId);
    }


    public void doneTodoById(int todoId) {
        getTodoById(todoId).ifPresent(todo -> todo.setIsCompleted(true));
    }
}
