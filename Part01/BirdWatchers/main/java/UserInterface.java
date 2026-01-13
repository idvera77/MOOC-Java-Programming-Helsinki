import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private BirdDatabase birdDatabase;
    private static final String EXIT_VALUE = "Quit";
    private static final String ADD_VALUE = "Add";
    private static final String OBSERVATION_VALUE = "Observation";
    private static final String ONE_VALUE = "One";
    private static final String ALL_VALUE = "All";

    public UserInterface(Scanner scanner, BirdDatabase birdDatabase) {
        this.scanner = scanner;
        this.birdDatabase = birdDatabase;
    }

    public void start() {
        while (true) {
            System.out.print("?");
            String input = scanner.nextLine();
            if (input.equals(EXIT_VALUE)) {
                break;
            } else if (input.equals(ADD_VALUE)) {
                addBird();
            } else if (input.equals(OBSERVATION_VALUE)) {
                birdObservation();
            } else if (input.equals(ONE_VALUE)) {
                printOne();
            } else if (input.equals(ALL_VALUE)) {
                printAll();
            }
        }
    }

    private void addBird() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Name in Latin: ");
        String latinName = scanner.nextLine();
        birdDatabase.addBird(name, latinName);
    }

    private void birdObservation() {
        System.out.print("Bird?");
        String input = scanner.nextLine();

        Boolean flag = birdDatabase.birdObservation(input);
        if (!flag) {
            System.out.println("Not a bird!");
        }
    }

    private void printOne() {
        System.out.print("Bird?");
        String input = scanner.nextLine();

        Bird bird = birdDatabase.giveMeOne(input);
        if (bird != null) {
            System.out.println(bird);
        } else {
            System.out.println("Not a bird!");
        }
    }

    private void printAll() {
        for (Bird b : birdDatabase.getBirds()) {
            System.out.println(b);
        }
    }

}
