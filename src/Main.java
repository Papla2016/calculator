import java.util.logging.SocketHandler;

public class Main {

    public static String calc(String input) throws Exception {
        input = input.replace(" ", "");
        if (input.contains("\n")){
            throw new Exception();
        }
        char operator = ' ';
        int operatorIndex = -1;

        // Определяем индекс оператора в строке
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                operator = input.charAt(i);
                operatorIndex = i;
                break;
            }
        }
        if (operatorIndex == -1){
            throw new Exception();
        }
        Integer num1 = Integer.parseInt(input.substring(0,operatorIndex));
        Integer num2 = Integer.parseInt(input.substring(operatorIndex+1));
        if (num1 > 10 || num1 < 0 || num2 > 10 || num2 < 0){
            throw new Exception();
        }
        Integer num3 = switch (operator) {
            case '-' -> num1 - num2;
            case '+' -> num1 + num2;
            case '/' -> num1 / num2;
            case '*' -> num1 * num2;
            default -> null;
        };
        return String.valueOf(num3);
    }
}