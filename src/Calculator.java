import java.util.Iterator;

public class Calculator {
    private ConsoleWriter writer = new ConsoleWriter();
    private ConsoleReader reader = new ConsoleReader();
    private InFileOperationsStorage storage;

    public Calculator(User user) {
        storage = new InFileOperationsStorage(user.getMail());
    }

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

    public void showHistory() {
        Iterator<Operation> iterator = storage.getAllOperations().iterator();
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString());
        }
    }

    public void createOperation() {
        Operation operation = new Operation();
        writer.write("Enter num1");
        operation.setNum1(reader.readNumber());
        writer.write("Enter num2");
        operation.setNum2(reader.readNumber());
        writer.write("Enter operation (sum, sub, div, mul)");
        operation.setType(reader.readString());
        calculate(operation);
        writer.write(String.valueOf(operation.getResult()));
    }

    public InFileOperationsStorage getStorage() {
        return storage;
    }

    public void setStorage(InFileOperationsStorage storage) {
        this.storage = storage;
    }
}
