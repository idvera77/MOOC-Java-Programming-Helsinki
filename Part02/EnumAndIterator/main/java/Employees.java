import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employees {
    List<Person> personas;

    public Employees() {
        this.personas = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.personas.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.personas.addAll(peopleToAdd);
    }

    public void print() {
        this.personas.stream()
                .forEach(System.out::println);
    }

    public void print(Education education) {
        // 1. Pedimos el iterador de la lista
        Iterator<Person> iterator = this.personas.iterator();

        // 2. Mientras el dedo tenga algo delante...
        while (iterator.hasNext()) {
            // 3. Saltamos al siguiente y lo guardamos un momento
            Person nextPerson = iterator.next();

            // 4. Comparamos el enum
            if (nextPerson.getEducation() == education) {
                System.out.println(nextPerson);
            }
        }
    }

    public void fire(Education education) {
        this.personas.removeIf(p -> p.getEducation() == education);
    }
}
