
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);

        int row = 0;
        int col = size / 2;
        int totalNumbers = size * size;

        for (int i = 1; i <= totalNumbers; i++) {
            square.placeValue(col, row, i);

            // Guardamos la posición actual por si la siguiente está ocupada
            int nextRow = row - 1;
            int nextCol = col + 1;

            // Regla 1: Ajustar bordes
            if (nextRow < 0)
                nextRow = size - 1;
            if (nextCol >= size)
                nextCol = 0;

            // Regla 2: Si está ocupado, bajar una fila desde la original
            if (square.readValue(nextCol, nextRow) != 0) {
                row++; // Bajamos una fila
                // No cambiamos col, se queda en la misma
            } else {
                row = nextRow;
                col = nextCol;
            }
        }
        return square;
    }

}
