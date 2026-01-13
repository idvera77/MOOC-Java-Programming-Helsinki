
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointsRegister pointsRegister = new PointsRegister();
        UserInterface userInterface = new UserInterface(scanner, pointsRegister);

        userInterface.start();
        
    }
}
