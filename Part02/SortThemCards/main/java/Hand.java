import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cartas;

    public Hand() {
        this.cartas = new ArrayList<>();
    }

    public void add(Card card) {
        cartas.add(card);
    }

    public void print() {
        cartas.stream()
                .forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(this.cartas);
    }

    public int getSum() {
        return this.cartas.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    @Override
    public int compareTo(Hand hand) {
        int mySum = this.getSum();
        int otherSum = hand.getSum();
        return mySum - otherSum;
    }

    public void sortBySuit() {
        // Ordenamos la lista interna 'cards' usando tu nueva clase comparadora
        Collections.sort(this.cartas, new BySuitInValueOrder());
    }
}
