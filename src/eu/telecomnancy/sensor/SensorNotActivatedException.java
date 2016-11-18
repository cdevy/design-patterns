package eu.telecomnancy.sensor;

@SuppressWarnings("serial")
public class SensorNotActivatedException extends Exception {
    public SensorNotActivatedException(String message) {
        super(message);
    }
}
