import java.util.List;

public interface Storage {
    void save(Operation operation);

    List<Operation> getAllOperations();
}
