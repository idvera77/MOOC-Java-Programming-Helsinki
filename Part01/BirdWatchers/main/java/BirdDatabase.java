import java.util.ArrayList;

public class BirdDatabase {
    private ArrayList<Bird> birds;

    public BirdDatabase() {
        this.birds = new ArrayList<>();
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public void addBird(String name, String latinName) {
        Bird bird = new Bird(name, latinName);
        birds.add(bird);
    }

    public boolean birdObservation(String name) {
        for (Bird bird : birds) {
            if (bird.getName().equals(name)) {
                bird.addObservation();
                return true;
            }
        }
        return false;
    }

    public Bird giveMeOne(String name){
        for (Bird bird : birds) {
            if (bird.getName().equals(name)) {
                return bird;
            }
        }
        return null;
    }
}
