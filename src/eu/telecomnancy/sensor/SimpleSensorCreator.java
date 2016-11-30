package eu.telecomnancy.sensor;

public class SimpleSensorCreator implements Creator {

	public ISensor factoryMethod(SensorType type) {
		if (type.equals(SensorType.TEMPERATURE)) {
			return new TemperatureSensor();
		} else if (type.equals(SensorType.LEGACY)) {
			return new Adapter();
		} else {
			return new NewSensor();
		}
	}
}
