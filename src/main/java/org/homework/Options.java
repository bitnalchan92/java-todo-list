package org.homework;

public enum Options {
    ADD(1, "추가"), // 할 일 추가
    DELETE(2, "삭제"), // 할 일 삭제
    VIEW(3, "조회"), // 할 일 조회
    DONE(4, "완료"), // 할 일 완료
    EXIT(5, "종료"); // 프로그램 종료

    final private int num;
    final private String name;

    private Options(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
