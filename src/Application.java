public class Application {
    public void start() {
        Calculator calculator = new Calculator();

        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();
        boolean check = true;
        int action;

        while (check) {
            writer.write("1) Calculate expression");
            writer.write("2) Show history");
            writer.write("3) Exit");
            writer.write("Enter your action: ");
            action = (int) reader.readNumber();
            switch (action) {
                case 1:
                    Operation operation = new Operation();
                    writer.write("Enter num1");
                    operation.setNum1(reader.readNumber());
                    writer.write("Enter num2");
                    operation.setNum2(reader.readNumber());
                    writer.write("Enter operation (sum, sub, div, mul)");
                    operation.setType(reader.readType());
                    calculator.calculate(operation);
                    writer.write(String.valueOf(operation.getResult()));

                    break;
                case 2:
                    calculator.showHistory();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    writer.write("Enter correct action!");
                    break;
            }
        }
    }
}
