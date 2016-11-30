package eu.telecomnancy.sensor;


public class DecoratorFahrenheit extends Decorator {
	
	public DecoratorFahrenheit(ISensor sensor) {
		super(sensor);
	}
	
	public void switchType() {
		if (getScale().equals(TemperatureScale.CELSIUS)) {
			setScale(TemperatureScale.FAHRENHEIT);
			try {
				setValue(1.8*getValue() + 32);
			} catch (SensorNotActivatedException e) {
				e.printStackTrace();
			}
			
		} else {
			setScale(TemperatureScale.CELSIUS);
			try {
				setValue((getValue() - 32)/1.8);
			} catch (SensorNotActivatedException e) {
				e.printStackTrace();
			}
		}
	}
}
