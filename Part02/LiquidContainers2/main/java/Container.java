public class Container {
    private int liquid;
    private static final int LIMIT = 100;

    public Container() {
        this.liquid = 0;
    }

    public int contains() {
        return liquid;
    }

    public void add(int amount) {
        liquid = Math.min(LIMIT, liquid + Math.max(0, amount));
    }

    public void remove(int amount) {
        if (amount > 0) {
            liquid = Math.max(0, liquid - amount);
        }   
    }

    public String toString() {
        return liquid + "/" + LIMIT;
    }
}
