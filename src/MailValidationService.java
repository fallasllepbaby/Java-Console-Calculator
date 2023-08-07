import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidationService implements ValidationService {
    @Override
    public boolean validate(String mail) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(mail);
        return !matcher.matches();
    }
}
