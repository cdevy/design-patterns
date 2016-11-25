package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.TemperatureScale;

public class DecoratorFahrenheit extends Decorator {
	
	private TemperatureScale scale;
	
	public DecoratorFahrenheit(ISensor sensor) {
		super(sensor);
		scale = TemperatureScale.CELSIUS;
	}
	
	public double switchType(double oldValue) {
		if (scale.equals(TemperatureScale.CELSIUS)) {
			scale = TemperatureScale.FAHRENHEIT;
			if (oldValue != -1)
				return 1.8*oldValue + 32;
			
		} else {
			scale = TemperatureScale.CELSIUS;
			if (oldValue != -1)
				return (oldValue - 32)/1.8;
		}
		return -1;
	}
	
	public TemperatureScale getScale() {
		return scale;
	}

}
