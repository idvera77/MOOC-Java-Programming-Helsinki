import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private PointsRegister pointsRegister;
    private static final int EXIT_VALUE = -1;

    public UserInterface(Scanner scanner, PointsRegister pointsRegister) {
        this.scanner = scanner;
        this.pointsRegister = pointsRegister;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == EXIT_VALUE) {
                break;
            }
            pointsRegister.add(input);
        }
        System.out.println("Point average (all): " + pointsRegister.averagePoint());
        if (pointsRegister.averagePassing() == -1) {
            System.out.println("Point average (passing): -");
        } else {
            System.out.println("Point average (passing): " + pointsRegister.averagePassing());
        }
        System.out.println("Pass percentage: " + pointsRegister.passPercentage());
        printGradeDistribution();
    }

    public void printGradeDistribution() {
        System.out.println("Grade distribution:");
        int[] grades = pointsRegister.retrieveGradeDistribution();

        for (int i = 5; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int stars = 0; stars < grades[i]; stars++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
