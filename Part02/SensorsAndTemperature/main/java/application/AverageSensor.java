package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private List<Integer> history;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        if (this.sensors.isEmpty()) {
            return false;
        }

        return this.sensors.stream()
                .allMatch(s -> s.isOn());
    }

    @Override
    public void setOn() {
        this.sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        this.sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Sensor is off or has no sensors.");
        }

        int average = (int) this.sensors.stream()
                .mapToInt(s -> s.read())
                .average()
                .getAsDouble();

        this.history.add(average);

        return average;
    }

    public List<Integer> readings() {
        return this.history;
    }

}
