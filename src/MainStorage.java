import java.util.HashMap;

public class MainStorage {
    private HashMap<User, OperationsStorage> mainStorage = new HashMap<>();

    public HashMap<User, OperationsStorage> getMainStorage() {
        return mainStorage;
    }

}
