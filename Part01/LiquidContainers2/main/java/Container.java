public class Container {
    private int liquid;
    private static final int MAX_LIQUID = 100;

    public Container() {
        this.liquid = 0;
    }

    public int contains() {
        return liquid;
    }

    public void add(int amount) {
        if (amount > 0) {
            liquid = Math.min(MAX_LIQUID, liquid + amount);
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            liquid = Math.max(0, liquid - amount);
        }
    }

    public String toString() {
        return liquid + "/" + MAX_LIQUID;
    }
}
