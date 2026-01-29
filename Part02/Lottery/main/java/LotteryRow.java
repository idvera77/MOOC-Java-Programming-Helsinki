import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Inicializamos los números al crear el objeto
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public boolean containsNumber(int number) {
        // Usamos el método de ArrayList para saber si el número ya existe
        return this.numbers.contains(number);
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        Random random = new Random();

        // Queremos exactamente 7 números
        while (this.numbers.size() < 7) {
            // Generamos un número entre 1 y 40
            int drawnNumber = random.nextInt(40) + 1;

            // ¡Paso clave! Solo lo añadimos si NO está ya en la lista
            if (!this.containsNumber(drawnNumber)) {
                this.numbers.add(drawnNumber);
            }
        }
    }
}