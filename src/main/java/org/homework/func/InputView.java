package org.homework.func;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }



    public int getNum() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String getString() {
        return scanner.nextLine();
    }
}
