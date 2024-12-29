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
            Options option = Options.of(inputView.getOptionNum());
            switch (option) {
                case ADD:
                    String newContent = inputView.getNewTodoContent();
                    outputView.printAddResult(todoService.addTodo(newContent));
                    break;
                case DELETE:
                    int deleteId = Integer.parseInt(inputView.getDeleteId());
                    outputView.printDeleteResult(todoService.deleteTodoById(deleteId));
                    break;
                case VIEW:
                    int viewId = Integer.parseInt(inputView.getViewId());
                    outputView.printViewResult(todoService.getTodoById(viewId));
                    break;
                case DONE:
                    int todoId = Integer.parseInt(inputView.getDoneId());
                    outputView.printDoneResult(todoService.doneTodoById(todoId));
                    break;
                case EXIT:
                    inputView.closeScanner();
                    outputView.printExit();
                    return;
                default:
                    outputView.printError();
            }
        }
    }
}
