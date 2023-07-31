import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {

    private File filePath = new File("src/storage.txt");

    @Override
    public void save(Operation operation) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(operation.toStringForStorage());
            writer.write(10);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> getAllOperations() {
        List<Operation> operations = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            String operation = reader.readLine();
            while (operation != null) {
                String[] operationArray = operation.split(" ");
                Operation op = new Operation(Double.parseDouble(operationArray[0]), Double.parseDouble(operationArray[1]), operationArray[2], Double.parseDouble(operationArray[3]));
                operations.add(op);
                operation = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
