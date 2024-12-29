package org.homework.controller;

import org.homework.Options;
import org.homework.domain.Todo;
import org.homework.func.InputView;
import org.homework.func.OutputView;
import org.homework.service.TodoService;

public class TodoController {
    private final TodoService todoService;
    private final InputView inputView;
    private final OutputView outputView;

    public TodoController(TodoService todoService, InputView inputView, OutputView outputView) {
        this.todoService = todoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            inputView.printOptions();

            int optionNum = inputView.getNum();
            try {
                if (optionNum == Options.ADD.getNum()) {
                    String newContent = inputView.getNewTodoContent();
                    outputView.printAddResult(todoService.addTodo(newContent));
                } else if (optionNum == Options.DELETE.getNum()) {
                    deleteTodo();
                } else if (optionNum == Options.VIEW.getNum()) {
                    int todoId = Integer.parseInt(inputView.getViewTodoId());
                    outputView.printTodo(todoService.getTodoById(todoId));
                } else if (optionNum == Options.DONE.getNum()) {
                    doneTodo();
                } else if (optionNum == Options.EXIT.getNum()) {
                    outputView.printMessage("프로그램을 종료합니다.");
                    return;
                } else {
                    throw new IllegalArgumentException("올바른 옵션을 선택해주세요.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteTodo() {
        outputView.printMessage("삭제하고자 하는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        int todoId = inputView.getNum();

        if (todoService.getTodoById(todoId) == null) {
            outputView.printMessage("해당 ID의 할 일이 없습니다.\n");
        } else {
            todoService.deleteTodoById(todoId);
            outputView.printMessage("할 일이 삭제되었습니다. ID: [" + todoId + "]\n");
        }
    }

    private void doneTodo() {
        outputView.printMessage("완료 처리 하고자 하는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        int todoId = inputView.getNum();

        Todo todo = todoService.getTodoById(todoId);

        if (todo == null) {
            outputView.printMessage("해당 ID의 할 일이 없습니다.\n");
        } else {
            todoService.doneTodoById(todoId);
            outputView.printMessage("할 일이 완료 처리되었습니다. ID: [" + todoId + "]\n");
        }
    }
}
