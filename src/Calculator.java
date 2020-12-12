import java.util.logging.XMLFormatter;

public class Calculator {
    public Calculator() {
    }

    public static void calculate(int firstNumber, int secondNumber, String sign, boolean rome) throws Exception {
        int result = 0;
        switch (sign) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }
        if (rome){
            if (result != 0){
                System.out.println(RomeNumbers.RomanNumerals(result));
            } else{
                throw new Exception("Ответ ноль. Но я римской системе счисления его не было");
            }
        } else {
            System.out.println(result);
        }

    }
}