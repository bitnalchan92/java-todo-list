package org.homework;

import org.homework.func.Common;
import org.homework.func.Todo;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> todos = new HashMap<>(); // 할 일 목록을 관리할 HashMap
        Scanner scanner = new Scanner(System.in); // Scanner 객체

        int selectedOption = 0;
        while (selectedOption != Options.EXIT.getNum()) {
            Options.printOptions(); // 사용자에게 안내 출력 ( 옵션을 선택하세요... )

            String inputValue = scanner.nextLine();

            if (Common.regexNumCheck(inputValue)) {
                selectedOption = Integer.parseInt(inputValue);

                // 정규식에는 통과했지만 해당 번호가 Option에서 관리중인 유효한 옵션 넘버인지 확인
                boolean isValidNum = false;
                for (int validOption : Options.getIntArrOfOptionNum()) {
                    if (selectedOption == validOption) {
                        isValidNum = true;
                        break;
                    }
                }

                if (isValidNum) {
                    switch (Options.getOptionByNum(selectedOption)) {
                        case ADD:
                            Todo.addTodo(scanner, todos);
                            break;
                        case DELETE:
                            Todo.deleteTodo(scanner, todos);
                            break;
                        case VIEW:
                            Todo.viewTodo(scanner, todos);
                            break;
                    }
                } else {
                    System.out.println("선택 불가능한 옵션 번호입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}