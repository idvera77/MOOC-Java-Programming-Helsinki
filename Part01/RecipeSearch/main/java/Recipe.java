import java.util.ArrayList;

public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int cookingTime){
        this.name = name;
        this.cookingTime = cookingTime;
        ingredients = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getCookingTime(){
        return cookingTime;
    }

    public void addIngredients(String ingredient){
        ingredients.add(ingredient);
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }
}
