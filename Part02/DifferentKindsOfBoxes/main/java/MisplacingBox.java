import java.util.ArrayList;

public class MisplacingBox extends Box {
    private ArrayList<Item> items;

    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        // Siempre añadimos, no hay restricciones
        this.items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        // El requisito dice que NUNCA se encuentran las cosas
        return false;
    }
}