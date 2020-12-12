import java.util.Arrays;
import java.util.Scanner;

public class ExpressionReader {
    private static int firstNumber;
    private static int secondNumber;
    private static String sign;
    private static boolean isRome;
    private static boolean isClose;

    public ExpressionReader() {
    }

    public static void readData() throws Exception {
        //Ввод строки
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку для вычисления в формате: Число1 (пробел) Арифметический знак (пробел) Число 2");
        String input_line = in.nextLine();

        if (input_line.charAt(input_line.length() - 1) == '!'){
            isClose = true;
            return;
        }

        //Разбить на члены и знаки
        String[] words = splitToWords(input_line);
        if (isTreeParts(words)){

        } else {
            throw new Exception("Ошибка! Не верный формат ввода выражения");
        }

        // Проверяем знак
        sign = words[1];
        isSign(sign);

        //Проверяем все остальное
        //Одинаковый формат ввода
        if (isGeneralFormat(words[0], words[2])) {
            //Римские или Арабские
            if (isRome(words[0]) && isRome(words[2])) {
                isRome = true;
                //Лежат ли в заднном диапазоне
                if (isRange(RomeNumbers.valueOf(words[0]).getEqualValue(),RomeNumbers.valueOf(words[2]).getEqualValue())) {
                    firstNumber = RomeNumbers.valueOf(words[0]).getEqualValue();
                    secondNumber = RomeNumbers.valueOf(words[2]).getEqualValue();
                } else {
                    throw new Exception("Ошибка! Введенные числа не соответствуют заданному диапазону");
                }
            } else {
                isRome = false;
                int firstArabNumber = Integer.parseInt(words[0]);
                int secondArabNumber = Integer.parseInt(words[2]);
                //Лежат ли в заднном диапазоне
                if (isRange(firstArabNumber, secondArabNumber)) {
                    firstNumber = firstArabNumber;
                    secondNumber = secondArabNumber;
                } else {
                    throw new Exception("Ошибка! Введенные числа не соответствуют заданному диапазону");
                }
            }
        } else {
            throw new Exception("Ошибка! Введенные числа должны быть целыми и единого формата");
        }
    }

    public static String[] splitToWords(String input_line) {
        return input_line.split(" ");
    }

    public static void isSign(String sign) throws Exception {
        if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {
        } else {
            throw new Exception("Не верный формат знака!");
        }
    }

    private static boolean isRome(String number) {
        boolean isRome = false;
        for (RomeNumbers num : RomeNumbers.values()) {
            if (number.equals(num.name())) {
                isRome = true;
                break;
            }
        }
        return isRome;
    }

    private static boolean isArab(String num) {
        boolean isArab = false;
        try {
            Integer.valueOf(num);
            isArab = true;
        } catch (NumberFormatException ignored) {

        }
        return isArab;
    }

    private static boolean isGeneralFormat(String firstNumber, String secondNumber) {
        return isArab(firstNumber) && isArab(secondNumber) || isRome(firstNumber) && isRome(secondNumber);
    }

    private static boolean isRange(int firstNumber, int secondNumber) {
        return firstNumber >= 1 && firstNumber <= 10 && secondNumber >= 1 && secondNumber <= 10;
    }

    public static boolean isTreeParts(String[] parts) {
        return parts.length == 3;
    }

    public static boolean isIsRome() {
        return isRome;
    }

    public static int getFirstNumber() {
        return firstNumber;
    }

    public static int getSecondNumber() {
        return secondNumber;
    }

    public static String getSign() {
        return sign;
    }

    public static boolean isClose() {
        return isClose;
    }
}
