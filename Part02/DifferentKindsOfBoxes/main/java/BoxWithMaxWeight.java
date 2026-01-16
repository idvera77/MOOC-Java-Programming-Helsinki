import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        // Calculamos el peso actual sumando todos los items
        int currentWeight = 0;
        for (Item i : items) {
            currentWeight += i.getWeight();
        }

        // Solo añadimos si el peso actual + el nuevo no superan la capacidad
        if (currentWeight + item.getWeight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }

}
