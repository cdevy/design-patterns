package eu.telecomnancy.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 19:35
 */
public class SimpleSensorFactory extends SensorFactory {

    @Override
    public ISensor getSensor() {
        return new TemperatureSensor();
    }
}
