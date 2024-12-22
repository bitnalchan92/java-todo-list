package org.homework;

public enum Options {
    ADD(1, "추가"), DELETE(2, "삭제"), VIEW(3, "조회"), EXIT(4, "종료");

    final private int num;
    final private String name;


    private Options(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public static Options nameOf(String name) {
        for (Options o : Options.values()) {
            if (o.getName().equals(name)) {
                return o;
            }
        }

        return null;
    }

    public static void printOptions() {
        Options[] options = Options.values();

        System.out.print("옵션을 선택하세요: ");

        for (int i = 0; i < options.length; i++) {
            Options option = options[i];
            String format = i < options.length - 1 ? "%s.%s, " : "%s.%s ~> ";

            System.out.printf(format, option.getNum(), option.getName());
        }
    }

    public static int[] getIntArrOfOptionNum() {
        Options[] options = Options.values();
        int[] validOptionNumbers = new int[options.length];
        for (int i = 0; i < options.length; i++) {
            validOptionNumbers[i] = options[i].getNum();
        }

        return validOptionNumbers;
    }

    public static Options getOptionByNum(int optionNum) {
        Options result = null;

        for (Options option : Options.values()) {
            if (option.getNum() == optionNum) {
                result = option;
            }
        }

        return result;
    }
}