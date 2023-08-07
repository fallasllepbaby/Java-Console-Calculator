import java.util.ArrayList;
import java.util.List;

public class OperationsStorage {
    private List<Operation> operationsStorage = new ArrayList<>();

    public void save(Operation operation) {
        operationsStorage.add(operation);
    }

    public List<Operation> getAllOperations() {
        return new ArrayList<>(operationsStorage);
    }

}
