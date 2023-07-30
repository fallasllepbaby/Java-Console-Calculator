import java.util.Iterator;

public class Calculator {

    ConsoleWriter writer = new ConsoleWriter();
    private Storage storage = new CollectionStorage();
    public void calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                storage.save(operation);
                break;
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                storage.save(operation);
                break;
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                storage.save(operation);
                break;
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                storage.save(operation);
                break;
        }
    }

    public void showHistory() {
        Iterator<Operation> iterator = storage.getAllOperations().iterator();
        while (iterator.hasNext()) {
            writer.write(iterator.next().toString());
        }
    }
}
