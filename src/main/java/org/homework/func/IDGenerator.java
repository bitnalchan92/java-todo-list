package org.homework.func;

public class IDGenerator {
    private int todoId = 1;

    public int generateTodoId() {
        return todoId++;
    }
}
