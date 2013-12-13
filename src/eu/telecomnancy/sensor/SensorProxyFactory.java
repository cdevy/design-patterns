package eu.telecomnancy.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 19:33
 */
public class SensorProxyFactory extends SensorFactory {
    @Override
    public ISensor getSensor() {
        return new SensorProxy(new TemperatureSensor(), new SimpleSensorLogger());
    }
}
