package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;

public class App {

    public static void main(String[] args) {
        ISensor sensor = new TemperatureSensor();
        new ConsoleUI(sensor);
    }

}