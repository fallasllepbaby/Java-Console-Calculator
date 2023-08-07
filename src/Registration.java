import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Registration {
    private ConsoleReader reader = new ConsoleReader();
    private ConsoleWriter writer = new ConsoleWriter();
    private ArrayList<User> users = new ArrayList<>();
    public void signUp() {
        writer.write("Enter your mail: ");
        String mail = reader.readString();
        writer.write("Enter your password: ");
        String password = reader.readString();
        User user = new User(mail, password);
        users.add(user);
    }

    public User logIn() {
        writer.write("Enter your mail: ");
        String mail = reader.readString();
        writer.write("Enter your password: ");
        String password = reader.readString();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMail().equals(mail) && users.get(i).getPassword().equals(password)) {
                writer.write("Welcome " + mail);
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
