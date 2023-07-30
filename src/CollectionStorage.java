import java.util.ArrayList;
import java.util.List;

public class CollectionStorage implements Storage {
    private List<Operation> storage = new ArrayList<>();
    @Override
    public void save(Operation operation) {
        storage.add(operation);
    }

    @Override
    public List<Operation> getAllOperations() {
        return new ArrayList<>(storage);
    }

}
