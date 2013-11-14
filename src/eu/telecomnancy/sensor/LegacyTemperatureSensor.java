package eu.telecomnancy.sensor;

import java.util.Random;

public class LegacyTemperatureSensor {
    private boolean state = false;
    private double start = -20;
    private double end = 100;
    private double value;
    private AcquiringThread worker = null;

    /**
     * Enable/disable the sensor.
     *
     * @return the current sensor status.
     */
    public synchronized boolean onOff() {
        this.state = ! this.state;
        if (this.state) {
            this.worker = new AcquiringThread();
            this.worker.start();
        } else {
            this.worker.disable();
            this.worker = null;
        }

        return this.state;
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
        return this.value;
    }

    private class AcquiringThread extends Thread {
        private boolean active = true;

        /**
         * Stop the acquiring thread. There is no way to start it again ;)
         */
        public void disable() {
            this.active = false;
        }

        @Override
        public void run() {
            while (this.active) {
                double random = (new Random()).nextDouble();
                value = start + (random * (end - start));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
