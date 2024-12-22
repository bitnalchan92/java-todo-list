package org.homework.repository;

import org.homework.domain.Todo;

import java.util.ArrayList;

public class TodoRepository {
    private final ArrayList<Todo> todos = new ArrayList<>();

    public int addTodo(Todo todo) {
        int newTodoId = getNewTodoId(todos);

        todo.setId(newTodoId);
        todo.setIsCompleted("미완료");

        todos.add(todo);

        return newTodoId;
    }

    private int getNewTodoId(ArrayList<Todo> todos) {
        return todos.size() + 1;
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
