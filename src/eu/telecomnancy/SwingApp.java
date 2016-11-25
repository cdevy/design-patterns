package eu.telecomnancy;

import eu.telecomnancy.sensor.Adapter;
import eu.telecomnancy.sensor.Decorator;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.NewSensor;
import eu.telecomnancy.sensor.SensorProxy;
import eu.telecomnancy.sensor.TemperatureSensor;
import eu.telecomnancy.ui.MainWindow;

@SuppressWarnings("unused")
public class SwingApp {

    public static void main(String[] args) {
        /*
		ISensor sensor = new TemperatureSensor();
        new MainWindow(sensor);
        */
        
        /*
		ISensor adaptedSensor = new Adapter();
		new MainWindow(adaptedSensor);
		*/
    	
		/*
        ISensor newSensor = new NewSensor();
        new MainWindow(newSensor);
        */
    	
    	/*
        ISensor proxySensor = new SensorProxy(new TemperatureSensor());
        new MainWindow(proxySensor);
        */

        new MainWindow(new TemperatureSensor());
    }

}
