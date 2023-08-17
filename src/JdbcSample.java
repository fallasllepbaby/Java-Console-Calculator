import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSample {
    private List<Operation> operationsStorage = new ArrayList<>();

    public void insertUserMail(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users values (?, ?)");
        preparedStatement.setString(1, user.getMail());
        preparedStatement.setString(2, "");
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void update(User user, Operation operation) throws SQLException {
        operationsStorage.add(operation);
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("update users set operations = ? where user_mail = ?");
        preparedStatement.setString(1, user.getMail());
        preparedStatement.setString(2, operationsStorage.toString());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public String getAllOperations(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "root");
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select operations from users where user_mail = ?");
        preparedStatement.setString(1, user.getMail());
        String operations = String.valueOf(statement.executeQuery(preparedStatement.toString()));
        return operations;
    }

}
