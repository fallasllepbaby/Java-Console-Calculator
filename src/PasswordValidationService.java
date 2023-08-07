import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidationService implements ValidationService {
//    At least 8 characters long
//    Contains at least one uppercase letter
//    Contains at least one lowercase letter
//    Contains at least one digit
//    May contain special characters (such as !@#$%^&*()-_=+[]{}|;:'",.<>?/)
    @Override
    public boolean validate(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
}
