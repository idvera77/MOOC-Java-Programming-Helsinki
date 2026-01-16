import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> itemInBox;

    public OneItemBox() {
        this.itemInBox = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        // Solo añadimos si la lista está vacía
        if (this.itemInBox.isEmpty()) {
            this.itemInBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.itemInBox.contains(item);
    }
}