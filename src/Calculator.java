import java.util.Iterator;

public class Calculator {
    private ConsoleWriter writer = new ConsoleWriter();
    private ConsoleReader reader = new ConsoleReader();
    private Storage storage = new FileStorage();

    private void calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum" -> {
                operation.setResult(operation.getNum1() + operation.getNum2());
                storage.save(operation);
            }
            case "sub" -> {
                operation.setResult(operation.getNum1() - operation.getNum2());
                storage.save(operation);
            }
            case "div" -> {
                operation.setResult(operation.getNum1() / operation.getNum2());
                storage.save(operation);
            }
            case "mul" -> {
                operation.setResult(operation.getNum1() * operation.getNum2());
                storage.save(operation);
            }
        }
    }

    private void showHistory() {
        Iterator<Operation> iterator = storage.getAllOperations().iterator();
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString());
        }
    }

    private void createOperation() {
        Operation operation = new Operation();
        writer.write("Enter num1");
        operation.setNum1(reader.readNumber());
        writer.write("Enter num2");
        operation.setNum2(reader.readNumber());
        writer.write("Enter operation (sum, sub, div, mul)");
        operation.setType(reader.readType());
        calculate(operation);
        writer.write(String.valueOf(operation.getResult()));
    }

    public void getMenu() {
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
                    createOperation();
                    break;
                case 2:
                    showHistory();
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
