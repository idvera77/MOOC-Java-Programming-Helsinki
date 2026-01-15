import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> map;

    public StorageFacility() {
        this.map = new HashMap<>();
    }

    public void add(String unit, String item) {
        map.putIfAbsent(unit, new ArrayList<>());
        ArrayList<String> equipamiento = map.get(unit);
        equipamiento.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return map.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        if (map.containsKey(storageUnit)) {
            map.get(storageUnit).remove(item);
        }
        if (map.get(storageUnit).isEmpty()) {
            map.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        return new ArrayList<>(map.keySet());
    }

}
