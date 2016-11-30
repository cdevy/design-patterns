package eu.telecomnancy;

import eu.telecomnancy.sensor.SimpleSensorCreator;
import eu.telecomnancy.ui.ConsoleUI;
import eu.telecomnancy.sensor.SensorType;

public class App {

    public static void main(String[] args) {
    	SimpleSensorCreator creator = new SimpleSensorCreator();
    	/**
    	 *  SensorType.TEMPERATURE, SensorType.LEGACY ou SensorType.NEW
    	 */
        new ConsoleUI(creator.factoryMethod(SensorType.TEMPERATURE));
    }

}