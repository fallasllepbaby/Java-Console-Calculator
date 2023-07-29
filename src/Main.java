import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Operation operation = new Operation();

        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        Scanner scanner = new Scanner(System.in);
        writer.write("Enter num1");
        operation.setNum1(reader.readNumber());
        writer.write("Enter num2");
        operation.setNum2(reader.readNumber());
        writer.write("Enter operation (sum, sub, div, mul)");
        operation.setType(reader.readType());
        calculator.calculate(operation);

        writer.write(String.valueOf(operation.getResult()));
    }
}
