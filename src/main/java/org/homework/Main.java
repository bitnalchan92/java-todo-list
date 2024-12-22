package org.homework;

import org.homework.controller.TodoController;
import org.homework.func.InputView;
import org.homework.func.OutputView;
import org.homework.repository.TodoRepository;
import org.homework.service.TodoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DI
        Scanner scanner = new Scanner(System.in);
        TodoRepository todoRepository = new TodoRepository();
        TodoService todoService = new TodoService(todoRepository);

        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        TodoController todoController = new TodoController(todoService, inputView, outputView);

        // Application run
        todoController.run();
    }
}
