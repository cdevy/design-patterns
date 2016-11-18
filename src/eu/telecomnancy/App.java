package eu.telecomnancy;

import eu.telecomnancy.sensor.Adapter;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewSensor;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;

public class App {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		ISensor sensor = new TemperatureSensor();
        @SuppressWarnings("unused")
		ISensor adaptedSensor = new Adapter();
        ISensor newSensor = new NewSensor();
        //new ConsoleUI(sensor);
        //new ConsoleUI(adaptedSensor);
        new ConsoleUI(newSensor);
    }

}