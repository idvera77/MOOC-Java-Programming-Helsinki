import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> owners;

    public VehicleRegistry() {
        this.owners = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        return owners.putIfAbsent(licensePlate, owner) == null;
    }

    public String get(LicensePlate licensePlate) {
        return owners.getOrDefault(licensePlate, null);
    }

    public boolean remove(LicensePlate licensePlate) {
        return owners.remove(licensePlate) != null;
    }

    public static String sanitizedString(String string) {
        if (string == null) {
            return "";
        }
        return string.toLowerCase().trim();
    }

    public void printLicensePlates() {
        for (LicensePlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> listaNombres = new ArrayList<>();
        for (String nombre : owners.values()) {
            if (!listaNombres.contains(nombre)) {
                listaNombres.add(nombre);
                System.out.println(nombre);
            }
        }

    }
}
