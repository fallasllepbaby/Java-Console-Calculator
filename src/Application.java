import java.sql.SQLException;

public class Application {

    private ConsoleWriterService writer = new ConsoleWriterService();
    private ConsoleReaderService reader = new ConsoleReaderService();
    
    private UserStorage userStorage = new UserStorage();
    private Registration registration = new Registration(userStorage);
    private Authentication authentication = new Authentication(userStorage);
    private Calculator calculator;
    private JdbcSample jdbcSample = new JdbcSample();

    private ConsoleSession consoleSession;
    private boolean mainCheck = true;
    public void start() {
        while (mainCheck) {
            if (consoleSession == null) {
                showGuestMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private void showGuestMenu() {
        boolean check = true;
        int action;

        while (check) {
            writer.write("1) Log in");
            writer.write("2) Sign up");
            writer.write("3) Exit");
            writer.write("Enter your action: ");
            action = (int) reader.readNumber();
            switch (action) {
                case 1:
                    User user = authentication.logIn();
                    if (user == null) {
                        writer.write("There is no such user. Try one more time.");
                    } else {
                        consoleSession = new ConsoleSession();
                        calculator = new Calculator(user);
                        check = false;
                    }
                    break;
                case 2:
                    registration.signUp();
                    int amountOfUsers = userStorage.getUsers().size();
                    try {
                        jdbcSample.insertUserMail(userStorage.getUsers().get(amountOfUsers - 1));
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 3:
                    check = false;
                    mainCheck = false;
                    break;
                default:
                    writer.write("Enter correct action!");
                    break;
            }
        }
    }

    private void showUserMenu() {
        boolean check = true;
        int action;

        while (check) {
            writer.write("1) Calculate expression");
            writer.write("2) Show history");
            writer.write("3) Log out");
            writer.write("Enter your action: ");
            action = (int) reader.readNumber();
            switch (action) {
                case 1:
                    calculator.createOperation();
                    break;
                case 2:
                //    calculator.showHistory();
                    break;
                case 3:
                    consoleSession = null;
                    check = false;
                    break;
                default:
                    writer.write("Enter correct action!");
                    break;
            }
        }
    }
}
