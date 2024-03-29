package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.Observer;

public class Adapter extends LegacyTemperatureSensor implements ISensor {
	
	private double value;
	private TemperatureScale scale;
	private Observer observer;

	public void on() {
		if (!getStatus()) {
			onOff();
			value = 0;
			scale = TemperatureScale.CELSIUS;
		}
	}

	public void off() {
		if (getStatus()) {
			onOff();
		}
	}

	public void update() throws SensorNotActivatedException {
        if (getStatus()) {
        	value = getTemperature();
        	notifyObserver();
        }
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	public double getValue() throws SensorNotActivatedException {
		if (getStatus())
			return value;
		else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public void attach(Observer o) {
		if (observer == null) {
			observer = o;
		} else {
			System.out.println("Observer could not be attached to Adapter: Adapter must have only one Observer!");
		}
	}

	public void detach(Observer o) {
		if (observer.equals(o)) {
			observer = null;
		} else {
			System.out.println("Observer could not be detached from Adapter because it was not attached to it!");
		}
	}

	public void notifyObserver() {
		if (observer != null) {
			observer.update();
		}
	}

	public TemperatureScale getScale() {
		return scale;
	}

	public void setScale(TemperatureScale scale) {
		this.scale = scale;
	}
}
