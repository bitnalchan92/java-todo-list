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
        todo.setIsCompleted("미완료");

        todos.add(todo);

        return newTodoId;
    }

    public Todo getTodoById(int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                return todo;
            }
        }

        return null;
    }

    public void deleteTodoById(int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todos.remove(todo);
                break;
            }
        }
    }

    public void doneTodoById(int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                todo.setIsCompleted("완료");
                break;
            }
        }
    }
}
