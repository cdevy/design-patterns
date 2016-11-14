package eu.telecomnancy.sensor;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/12/13
 * Time: 18:16
 */
public class SimpleSensorLogger implements SensorLogger {
    public void log(LogLevel level, String message) {
        System.out.println(level.name() + " " + message);
    }
}
