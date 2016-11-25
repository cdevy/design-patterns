package eu.telecomnancy;

import eu.telecomnancy.sensor.Adapter;
import eu.telecomnancy.sensor.Decorator;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewSensor;
import eu.telecomnancy.sensor.SensorProxy;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.ConsoleUI;
import eu.telecomnancy.ui.MainWindow;

@SuppressWarnings("unused")
public class App {

    public static void main(String[] args) {
    	/*
		ISensor sensor = new TemperatureSensor();
        new ConsoleUI(sensor);
        */
        
        /*
		ISensor adaptedSensor = new Adapter();
		new ConsoleUI(adaptedSensor);
		*/
    	
		/*
        ISensor newSensor = new NewSensor();
        new ConsoleUI(newSensor);
        */
    	
    	/*
        ISensor proxySensor = new SensorProxy(new TemperatureSensor());
        new ConsoleUI(proxySensor);
        */

        new ConsoleUI(new TemperatureSensor());
    }

}