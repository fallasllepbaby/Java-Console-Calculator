public class Calculator {
    public void calculate(Operation operation) {
        switch (operation.getType()) {
            case "sum" -> operation.setResult(operation.getNum1() + operation.getNum2());
            case "sub" -> operation.setResult(operation.getNum1() - operation.getNum2());
            case "div" -> operation.setResult(operation.getNum1() / operation.getNum2());
            case "mul" -> operation.setResult(operation.getNum1() * operation.getNum2());
        }

    }
}
