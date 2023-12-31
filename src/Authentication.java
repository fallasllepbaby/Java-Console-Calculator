import java.util.ArrayList;

public class Authentication {
    private ConsoleReaderService reader = new ConsoleReaderService();
    private ConsoleWriterService writer = new ConsoleWriterService();
    private ValidationService mailValidationService = new MailValidationService();
    private ValidationService passwordValidationService = new PasswordValidationService();
    private ArrayList<User> users = new ArrayList<>();

    public Authentication(UserStorage userStorage) {
        this.users = userStorage.getUsers();
    }

    public User logIn() {
        writer.write("Enter your mail: ");
        String mail = reader.readString();
        while (mailValidationService.validate(mail)) {
            writer.write("Try one more time: ");
            mail = reader.readString();
        }
        writer.write("Enter your password: ");
        String password = reader.readString();
        while (passwordValidationService.validate(password)) {
            writer.write("Try one more time: ");
            password = reader.readString();
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getMail().equals(mail) && users.get(i).getPassword().equals(password)) {
                writer.write("Welcome " + mail);
                return users.get(i);
            }
        }
        return null;
    }
}
