package eu.telecomnancy.sensor;

import eu.telecomnancy.sensor.Creator;

public class DecoratorFahrenheitCreator implements Creator {

	public ISensor factoryMethod(SensorType type) {
		SimpleSensorCreator creator = new SimpleSensorCreator();
		return new DecoratorFahrenheit(creator.factoryMethod(type));
	}
	
	public ISensor factoryMethod(ISensor sensor) {
		return new DecoratorFahrenheit(sensor);
	}

}
