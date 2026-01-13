
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Container first = new Container();
        Container second = new Container();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount > 0) {
                    first.add(amount);
                }
            } else if (command.equals("move")) {
                if (amount > 0) {
                    int toMove = Math.min(first.contains(), amount);
                    first.remove(toMove);
                    second.add(toMove);
                }
            } else if (command.equals("remove")) {
                if (amount > 0) {
                    second.remove(amount);
                }
            }
        }
    }

}
