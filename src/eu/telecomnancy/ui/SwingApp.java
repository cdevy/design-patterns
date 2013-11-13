package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;

public class SwingApp {

    public static void main(String[] args) {
        ISensor sensor = new TemperatureSensor();
        new MainWindow(sensor);
    }

}
