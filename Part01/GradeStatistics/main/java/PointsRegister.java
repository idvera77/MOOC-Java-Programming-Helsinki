import java.util.ArrayList;

public class PointsRegister {
    private ArrayList<Integer> points;
    private static final int MIN_POINTS = 0;
    private static final int MAX_POINTS = 100;
    private int sumaTotal;
    private int sumaAprobados;
    private int contadorAprobados;

    public PointsRegister() {
        this.points = new ArrayList<>();
        this.sumaTotal = 0;
        this.sumaAprobados = 0;

    }

    public void add(int numero) {
        if (numero >= MIN_POINTS && numero <= MAX_POINTS) {
            points.add(numero);
            sumaTotal += numero;

            if (numero >= 50) {
                sumaAprobados += numero;
                contadorAprobados++;
            }
        }
    }

    public double averagePoint() {
        if (points.isEmpty()) {
            return -1.0;
        }
        return 1.0 * sumaTotal / points.size();
    }

    public double averagePassing() {
        if (contadorAprobados == 0) {
            return -1.0;
        }
        return 1.0 * sumaAprobados / contadorAprobados;
    }

    public double passPercentage() {
        return 100.0 * contadorAprobados / points.size();
    }

    public int[] retrieveGradeDistribution() {
        int[] grades = new int[6];
        for (int p : this.points) {
            int grade = pointsToGrade(p);
            grades[grade]++;
        }
        return grades;
    }

    private int pointsToGrade(int calificacion) {
        if (calificacion < 50)
            return 0;
        if (calificacion < 60)
            return 1;
        if (calificacion < 70)
            return 2;
        if (calificacion < 80)
            return 3;
        if (calificacion < 90)
            return 4;
        return 5;
    }
}
