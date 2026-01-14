import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> lista;

    public TodoList() {
        this.lista = new ArrayList<>();
    }

    public void add(String task) {
        lista.add(task);
    }

    public void print() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ": " + lista.get(i));
        }
    }

    public void remove(int number) {
        if (number > 0 && number <= lista.size()) {
            lista.remove(number - 1);
        }
    }

}
