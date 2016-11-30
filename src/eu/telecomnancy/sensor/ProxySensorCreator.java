package eu.telecomnancy.sensor;

public class ProxySensorCreator implements Creator {

	public ISensor factoryMethod(SensorType type) {
		SimpleSensorCreator creator = new SimpleSensorCreator();
		return new ProxySensor(creator.factoryMethod(type));
	}
}
