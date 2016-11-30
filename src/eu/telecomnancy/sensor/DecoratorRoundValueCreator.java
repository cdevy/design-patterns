package eu.telecomnancy.sensor;

public class DecoratorRoundValueCreator implements Creator {

	public ISensor factoryMethod(SensorType type) {
		SimpleSensorCreator creator = new SimpleSensorCreator();
		return new DecoratorRoundValue(creator.factoryMethod(type));
	}
	
	public ISensor factoryMethod(ISensor sensor) {
		return new DecoratorRoundValue(sensor);
	}

}
