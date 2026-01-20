import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    private List<Movable> herd;

    public Herd() {
        this.herd = new ArrayList<>();
    }

    public String toString() {
        String value = "";
        for (Movable member : herd) {
            value = value + member.toString() + "\n";
        }
        return value;
    }

    public void addToHerd(Movable movable){
        this.herd.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : herd) {
            movable.move(dx, dy);
        }
    }

}
