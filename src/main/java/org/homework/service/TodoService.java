package org.homework.service;

import org.homework.domain.Todo;
import org.homework.repository.TodoRepository;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public int addTodo(Todo todo) {
        return todoRepository.addTodo(todo);
    }

    public void deleteTodoById(int todoId) {
        todoRepository.deleteTodoById(todoId);
    }

    public Todo getTodoById(int todoId) {
        return todoRepository.getTodoById(todoId).orElse(null);
    }

    public void doneTodoById(int todoId) {
        todoRepository.doneTodoById(todoId);
    }
}
