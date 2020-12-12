import sun.swing.StringUIClientPropertyKey;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        ExpressionReader expression = new ExpressionReader();
        while (true) {
            try {
                expression.readData();
            } catch (Exception e) {
                System.out.println("Что то пошло не так");
                System.err.println(e.getMessage());
                continue;
            }
            if (ExpressionReader.isClose()) {
                System.out.println("В выражении присутствует знак выхода... Завершение работы программы.");
                break;
            }

            try {
                Calculator.calculate(
                        ExpressionReader.getFirstNumber(),
                        ExpressionReader.getSecondNumber(),
                        ExpressionReader.getSign(),
                        ExpressionReader.isIsRome());
            } catch (Exception e) {
                System.out.println("Что то пошло не так");
                System.err.println(e.getMessage());
                continue;
            }

        }

    }
}
