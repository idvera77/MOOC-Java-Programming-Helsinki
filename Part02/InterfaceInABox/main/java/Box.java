import java.util.ArrayList;

public class Box implements Packable {
    private ArrayList<Packable> box;
    private double maxCapacity;

    public Box(double maxCapacity) {
        this.box = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    public void add(Packable item) {
        if (this.maxCapacity >= this.weight() + item.weight()) {
            box.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable packable : box) {
            weight += packable.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + box.size() + " items, total weight " + this.weight() + " kg";
    }
}
