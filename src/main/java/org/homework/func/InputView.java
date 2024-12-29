package org.homework.func;

import org.homework.Options;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
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

    public int getOptionNum() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getNewTodoContent() {
        System.out.print("새로운 할 일을 입력해주세요 ~> ");
        return scanner.nextLine();
    }

    public String getViewId() {
        System.out.print("조회하려는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        return scanner.nextLine();
    }

    public String getDeleteId() {
        System.out.print("삭제하려는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        return scanner.nextLine();
    }

    public String getDoneId() {
        System.out.print("완료하려는 할 일의 고유번호(ID)를 입력해주세요 ~> ");
        return scanner.nextLine();
    }

    public void closeScanner() {
        scanner.close();
    }
}
