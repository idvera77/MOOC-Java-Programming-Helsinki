package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean status;

    public TemperatureSensor() {
        this.status = false;

    }

    @Override
    public boolean isOn() {
        return this.status;
    }

    @Override
    public void setOn() {
        this.status = true;
    }

    @Override
    public void setOff() {
        this.status = false;
    }

    @Override
    public int read() {
        if (!this.status) {
            throw new IllegalStateException("Sensor is off. Turn it on before reading.");
        }

        return new Random().nextInt(61) - 30;
    }

}
