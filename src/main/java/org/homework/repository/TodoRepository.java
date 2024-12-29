package org.homework.repository;

import org.homework.domain.Todo;
import org.homework.func.IDGenerator;

import java.util.ArrayList;

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

    public Todo getTodoById(int todoId) {
        return todos.stream()
                .filter(todo -> todo.getId() == todoId)
                .findFirst()
                .orElse(null);
    }

    public void deleteTodoById(int todoId) {
        todos.removeIf(todo -> todo.getId() == todoId);
    }

    public void doneTodoById(int todoId) {
        Todo todo = getTodoById(todoId);
        if (todo != null) todo.setIsCompleted(true);
    }
}
