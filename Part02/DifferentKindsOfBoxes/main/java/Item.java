
public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        // Si apuntan a la misma dirección, son iguales
        if (this == o) {
            return true;
        }

        // Si el objeto es nulo o de otra clase, no son iguales
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // Convertimos el objeto genérico a un Item
        Item compared = (Item) o;

        // Comparamos SOLO el nombre (ignoramos el peso como pide el MOOC)
        if (this.name == null) {
            return compared.name == null;
        }

        return this.name.equals(compared.name);
    }

    @Override
    public int hashCode() {
        // Siempre que sobrescribas equals, debes sobrescribir hashCode
        if (this.name == null) {
            return 0;
        }
        return this.name.hashCode();
    }

}
