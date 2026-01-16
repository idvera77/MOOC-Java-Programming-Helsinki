public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        history = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        // 1. Llamamos al método del padre para que sume el balance
        super.addToWarehouse(amount);

        // 2. Guardamos en nuestro historial el balance ACTUAL después de la suma
        this.history.add(this.getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        // 1. Llamamos al método del padre para que reste y nos devuelva cuánto sacó
        double received = super.takeFromWarehouse(amount);

        // 2. Guardamos en nuestro historial el balance ACTUAL después de la resta
        this.history.add(this.getBalance());

        // 3. Devolvemos lo que el padre calculó (muy importante no olvidar el return)
        return received;
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
    }

}
