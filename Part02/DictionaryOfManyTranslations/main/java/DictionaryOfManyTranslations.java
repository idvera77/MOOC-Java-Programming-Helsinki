import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> map;

    public DictionaryOfManyTranslations() {
        this.map = new HashMap<>();
    }

    public void add(String word, String translation) {
        map.putIfAbsent(word, new ArrayList<>());
        ArrayList<String> traducciones = map.get(word);
        traducciones.add(translation);
    }

    public ArrayList<String> translate(String word) {
        return map.getOrDefault(word, new ArrayList<>());
    }

    public void remove(String word) {
        map.remove(word);
    }
}
