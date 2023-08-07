import java.util.Scanner;

public class ConsoleReader {
    public double readNumber() {
        return scan().nextDouble();
    }

    public String readString() {
        return scan().next();
    }

    private Scanner scan() {
        return new Scanner(System.in);
    }

}
