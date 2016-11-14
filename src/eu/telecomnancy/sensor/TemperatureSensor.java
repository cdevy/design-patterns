package eu.telecomnancy.sensor;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    boolean state;
    double value = 0;

    public void on() {
        state = true;
    }

    public void off() {
        state = false;
    }

    public boolean getStatus() {
        return state;
    }

    public void update() throws SensorNotActivatedException {
        if (state)
            value = (new Random()).nextDouble() * 100;
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }

}
