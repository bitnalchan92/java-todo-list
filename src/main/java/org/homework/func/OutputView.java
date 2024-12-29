package org.homework.func;

import org.homework.domain.Todo;

public class OutputView {
    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printViewResult(Todo todo) {
        if (todo == null) {
            System.out.println("조회하려는 할 일이 없습니다.");
            return;
        }

        System.out.println("* 할 일 ID  : " + todo.getId());
        System.out.println("* 할 일 내용 : " + todo.getContent());
        System.out.println("* 할 일 상태 : " + (todo.getIsCompleted() ? "완료" : "미완료"));
    }

    public void printAddResult(int newTodoId) {
        System.out.println("할 일이 추가되었습니다. ID : [" + newTodoId + "]");
    }

    public void printDeleteResult(int deleteTodoId) {
        System.out.println(deleteTodoId == -1 ? "삭제하려는 할 일이 없습니다." : "할 일이 삭제되었습니다. ID : [" + deleteTodoId + "]");
    }

    public void printDoneResult(int doneTodoId) {
        System.out.println(doneTodoId == -1 ? "완료하려는 할 일이 없습니다." : "할 일이 완료 처리되었습니다. ID : [" + doneTodoId + "]");
    }

    public void printExit() {
        System.out.println("프로그램을 종료합니다.");
    }
}
