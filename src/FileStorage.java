import java.io.*;
import java.util.List;

public class FileStorage implements Storage {

    private File filePath = new File("src/storage.txt");
    /*FileReader fr = new FileReader(filePath);
    BufferedReader reader = new BufferedReader(fr);*/
    @Override
    public void save(Operation operation) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(operation.toStringForStorage());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> getAllOperations() {
        return null;
    }
}
