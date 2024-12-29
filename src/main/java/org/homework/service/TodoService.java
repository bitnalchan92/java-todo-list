package org.homework.service;

import org.homework.domain.Todo;
import org.homework.repository.TodoRepository;

import java.util.Optional;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public int addTodo(String newContent) {
        Todo todo = new Todo();
        todo.setContent(newContent);

        return todoRepository.addTodo(todo);
    }

    public int deleteTodoById(int todoId) {
        Optional<Todo> todo = todoRepository.getTodoById(todoId);

        if (todo.isPresent()) {
            todoRepository.deleteTodoById(todoId);
            return todoId;
        }

        return -1;
    }

    public Todo getTodoById(int todoId) {
        return todoRepository.getTodoById(todoId).orElse(null);
    }

    public void doneTodoById(int todoId) {
        todoRepository.doneTodoById(todoId);
    }
}
