import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileOperationsStorage {
    private File filePath;
    private List<Operation> operationsStorage = new ArrayList<>();
    public InFileOperationsStorage(String mail) {
        filePath = new File("src/filesJSON/" + mail + ".json");
    }

    public void save(Operation operation) {
        operationsStorage.add(operation);
        Gson gson = new Gson();
        String json = gson.toJson(operationsStorage);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(json);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Operation> getAllOperations() {
        Gson gson = new Gson();
        String json;
        TypeToken<List<Operation>> collectionType = new TypeToken<List<Operation>>(){};
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fr);
            json = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Operation> operations = gson.fromJson(json, collectionType);
        return operations;
    }

}
