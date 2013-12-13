package eu.telecomnancy.sensor;

import eu.telecomnancy.helpers.ReadPropertyFile;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 19:31
 */
public abstract class SensorFactory {
    public static ISensor makeSensor() {
        ReadPropertyFile rp = new ReadPropertyFile();
        Properties p = null;
        try {
            p = rp.readFile("/eu/telecomnancy/app.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String factory = p.getProperty("factory");
        ISensor sensor;
        sensor = null;
        try {
            SensorFactory sensorfactory = (SensorFactory) Class.forName(factory).newInstance();
            sensor = sensorfactory.getSensor();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sensor;
    }

    public abstract ISensor getSensor();
}
