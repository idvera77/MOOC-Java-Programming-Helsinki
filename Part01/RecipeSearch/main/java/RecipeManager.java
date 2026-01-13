import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeManager {
    private ArrayList<Recipe> recipes;

    public RecipeManager() {
        this.recipes = new ArrayList<>();
    }

    public void readRecipes(String fileName) {
        try {
            Scanner readFile = new Scanner(Paths.get(fileName));
            while (readFile.hasNextLine()) {
                String name = readFile.nextLine();
                int time = Integer.valueOf(readFile.nextLine());
                Recipe recipe = new Recipe(name, time);

                while (readFile.hasNextLine()) {
                    String line = readFile.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    recipe.addIngredients(line);
                }
                this.recipes.add(recipe);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: can't read the file.");
        }

    }

    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }

    public ArrayList<Recipe> findByName(String word) {
        ArrayList<Recipe> found = new ArrayList<>();

        for (Recipe r : this.recipes) {
            if (r.getName().contains(word)) {
                found.add(r);
            }
        }
        return found;
    }

    public ArrayList<Recipe> findByCookingTime(int cookingTime) {
        ArrayList<Recipe> found = new ArrayList<>();
        for (Recipe r : this.recipes) {
            if (r.getCookingTime() <= cookingTime) {
                found.add(r);
            }
        }
        return found;
    }

    public ArrayList<Recipe> findByIngredient(String word){
        ArrayList<Recipe> found = new ArrayList<>();
        for(Recipe r : this.recipes){
            if (r.getIngredients().contains(word)) {
                found.add(r);
            }
        }

        return found;
    }
}
