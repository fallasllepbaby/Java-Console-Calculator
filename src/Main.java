import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Operation operation = new Operation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter num1");
        operation.setNum1(scanner.nextDouble());
        System.out.println("Enter num2");
        operation.setNum2(scanner.nextDouble());
        System.out.println("Enter operation (sum, sub, div, mul)");
        operation.setType(scanner.next());
        calculator.calculate(operation);

        System.out.println(operation.getResult());
    }
}
