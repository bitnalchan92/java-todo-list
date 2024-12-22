package org.homework.func;

import org.homework.domain.Todo;

public class OutputView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printTodo(Todo todo) {
        System.out.println("* 할 일 ID  : " + todo.getId());
        System.out.println("* 할 일 내용 : " + todo.getContent());
        System.out.println("* 할 일 상태 : " + todo.getIsCompleted());
    }
}
