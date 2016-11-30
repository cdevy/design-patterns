package eu.telecomnancy;

import eu.telecomnancy.sensor.Adapter;
import eu.telecomnancy.sensor.Decorator;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewSensor;
import eu.telecomnancy.sensor.ProxySensor;
import eu.telecomnancy.sensor.SensorType;
import eu.telecomnancy.sensor.SimpleSensorCreator;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

@SuppressWarnings("unused")
public class SwingApp {

    public static void main(String[] args) {
        SimpleSensorCreator creator = new SimpleSensorCreator();
        /**
    	 *  SensorType.TEMPERATURE, SensorType.LEGACY ou SensorType.NEW
    	 */
        new MainWindow(creator.factoryMethod(SensorType.TEMPERATURE));
    }

}
