import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        // 1. Primero intentamos ordenar por Palo
        int comparacionPalos = c1.getSuit().ordinal() - c2.getSuit().ordinal();

        // 2. Si son de palos distintos, ya tenemos ganador. Devolvemos eso.
        if (comparacionPalos != 0) {
            return comparacionPalos;
        }

        // 3. Si son del MISMO palo (el resultado fue 0), desempatamos por VALOR
        return c1.getValue() - c2.getValue();
    }
}