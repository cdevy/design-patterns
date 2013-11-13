package eu.telecomnancy.sensor;

import java.util.Random;

public class LegacyTemperatureSensor extends Thread {
    private boolean state = false;
    private double start = -20;
    private double end = 100;
    private double value;

    /**
     * Enable/disable the sensor.
     *
     * @return the current sensor status.
     */
    public boolean onOff() {
        state = !state;
        if (state && !isAlive()) {   // on démarre le thread la première fois
            this.start();
        }
        return state;
    }

    /**
     * Get the status (enabled/disabled) of the sensor.
     *
     * @return the current sensor's status.
     */
    public boolean getStatus() {
        return this.state;
    }

    /**
     * Get the current temperature.
     *
     * @return the latest recorded temperature.
     */
    public double getTemperature() {
        return value;
    }

    @Override
    /**
     * Start the internal worker to acquire a new temperature value every 1s.
     * Caution! This method should not be directly called (Please call onOff() method instead).
     */
    public void run() {
        while (true) {
            double random = (new Random()).nextDouble();
            if (state)                                      // on change la valeur uniquement si l'état est actif
                value = start + (random * (end - start));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
