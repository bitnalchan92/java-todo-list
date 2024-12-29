package org.homework.controller;

import org.homework.Options;
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

            int optionNum = inputView.getOptionNum();
            try {
                if (optionNum == Options.ADD.getNum()) {
                    String newContent = inputView.getNewTodoContent();
                    outputView.printAddResult(todoService.addTodo(newContent));

                } else if (optionNum == Options.DELETE.getNum()) {
                    int todoId = Integer.parseInt(inputView.getDeleteId());
                    outputView.printDeleteResult(todoService.deleteTodoById(todoId));

                } else if (optionNum == Options.VIEW.getNum()) {
                    int todoId = Integer.parseInt(inputView.getViewId());
                    outputView.printViewResult(todoService.getTodoById(todoId));

                } else if (optionNum == Options.DONE.getNum()) {
                    int todoId = Integer.parseInt(inputView.getDoneId());
                    outputView.printDoneResult(todoService.doneTodoById(todoId));

                } else if (optionNum == Options.EXIT.getNum()) {
                    inputView.closeScanner();
                    outputView.printExit();
                    return;

                } else {
                    throw new IllegalArgumentException("올바른 옵션을 선택해주세요.");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
