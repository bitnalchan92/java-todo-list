package org.homework.func;

import org.homework.Options;
import org.homework.domain.Todo;

public class OutputView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printOptions() {
        Options[] options = Options.values();
        System.out.print("옵션을 선택하세요: ");
        for (int i = 0; i < options.length; i++) {
            Options option = options[i];
            String format = i < options.length - 1 ? "%s.%s, " : "%s.%s ~> ";

            System.out.printf(format, option.getNum(), option.getName());
        }
    }

    public void printTodo(Todo todo) {
        System.out.println("* 할 일 ID  : " + todo.getId());
        System.out.println("* 할 일 내용 : " + todo.getContent());
        System.out.println("* 할 일 상태 : " + (todo.getIsCompleted() ? "완료" : "미완료"));
    }
}
