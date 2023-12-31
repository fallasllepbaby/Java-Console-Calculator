import java.util.ArrayList;

public class Registration {
    private ConsoleReaderService reader = new ConsoleReaderService();
    private ConsoleWriterService writer = new ConsoleWriterService();
    private ValidationService mailValidationService = new MailValidationService();
    private ValidationService passwordValidationService = new PasswordValidationService();
    private ArrayList<User> users = new ArrayList<>();

    public Registration(UserStorage storage) {
        users = storage.getUsers();
    }
    public void signUp() {
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
        User user = new User(mail, password);
        users.add(user);
    }

}
