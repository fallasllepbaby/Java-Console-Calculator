import java.sql.SQLException;
import java.util.Iterator;

public class Calculator {
    private ConsoleWriterService writer = new ConsoleWriterService();
    private ConsoleReaderService reader = new ConsoleReaderService();
    private JdbcSample jdbcSample = new JdbcSample();
    private User user;

    public Calculator(User user) {
        this.user = user;
    }


    private void calculate(Operation operation) {
        Thread saveThread = new Thread(() -> {
            try {
                jdbcSample.update(user, operation);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        switch (operation.getType()) {
            case "sum" -> {
                operation.setResult(operation.getNum1() + operation.getNum2());
                saveThread.start();
            }
            case "sub" -> {
                operation.setResult(operation.getNum1() - operation.getNum2());
                saveThread.start();
            }
            case "div" -> {
                operation.setResult(operation.getNum1() / operation.getNum2());
                saveThread.start();
            }
            case "mul" -> {
                operation.setResult(operation.getNum1() * operation.getNum2());
                saveThread.start();
            }
        }
    }

    public void showHistory() throws SQLException {
        writer.write(jdbcSample.getAllOperations(user));
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

}
