package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorFactory;
import eu.telecomnancy.ui.ConsoleUI;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 19:37
 */
public class AppFactory {
    public static void main(String[] args) {
        ISensor sensor = SensorFactory.makeSensor();
        new ConsoleUI(sensor);
    }
}
