package eu.telecomnancy.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 18:07
 */
public class SensorProxy implements ISensor {
    private ISensor sensor;
    private SensorLogger log;

    public SensorProxy(ISensor _sensor, SensorLogger sensorLogger) {
        sensor = _sensor;
        log = sensorLogger;
    }

    @Override
    public void on() {
        log.log(LogLevel.INFO, "Sensor On");
        sensor.on();
    }

    @Override
    public void off() {
        log.log(LogLevel.INFO, "Sensor Off");
        sensor.off();
    }

    @Override
    public boolean getStatus() {
        log.log(LogLevel.INFO, "Sensor getStatus");
        return sensor.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
        log.log(LogLevel.INFO, "Sensor update");
        sensor.update();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        log.log(LogLevel.INFO, "Sensor value =" + sensor.getValue());
        return sensor.getValue();
    }
}
