import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private RecipeManager recipeManager;
    private static final String EXIT_VALUE = "stop";
    private static final String LIST = "list";
    private static final String FIND_NAME = "find name";
    private static final String FIND_COOKING_TIME = "find cooking time";
    private static final String FIND_INGREDIENT = "find ingredient";

    public UserInterface(Scanner scanner, RecipeManager recipeManager) {
        this.scanner = scanner;
        this.recipeManager = recipeManager;
    }

    public void start() {
        System.out.print("File to read:");
        String input = scanner.nextLine();
        recipeManager.readRecipes(input);

        printMenu();
        ;

        while (true) {
            System.out.print("\nEnter command: ");
            input = scanner.nextLine();
            if (input.equals(EXIT_VALUE)) {
                break;
            } else if (input.equals(LIST)) {
                listRecipes();
            } else if (input.equals(FIND_NAME)) {
                findByName();
            } else if (input.equals(FIND_COOKING_TIME)) {
                findByCookingTime();
            } else if (input.equals(FIND_INGREDIENT)) {
                findByIngredient();
            }

        }
    }

    private void printMenu() {
        System.out.println("\nCommands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }

    private void printRecipes(ArrayList<Recipe> recipesToPrint) {
        System.out.println("\nRecipes:");
        for (Recipe r : recipesToPrint) {
            System.out.println(r.getName() + ", cooking time: " + r.getCookingTime());
        }
    }

    private void listRecipes() {
        printRecipes(recipeManager.getRecipes());
    }

    private void findByName() {
        System.out.print("Search word: ");
        String word = scanner.nextLine();

        ArrayList<Recipe> results = recipeManager.findByName(word);
        printRecipes(results);
    }

    private void findByCookingTime() {
        System.out.print("Max cooking time: ");
        int time = Integer.valueOf(scanner.nextLine());

        ArrayList<Recipe> results = recipeManager.findByCookingTime(time);
        printRecipes(results);
    }

    public void findByIngredient() {
        System.out.print("Ingredient: ");
        String ingredientName = scanner.nextLine();

        ArrayList<Recipe> results = recipeManager.findByIngredient(ingredientName);
        printRecipes(results);
    }
}