
import java.util.HashMap;

public class MainStorage {
    private HashMap<User, InFileOperationsStorage> mainStorage = new HashMap<>();

    public HashMap<User,InFileOperationsStorage> getMainStorage() {
        return mainStorage;
    }

}
