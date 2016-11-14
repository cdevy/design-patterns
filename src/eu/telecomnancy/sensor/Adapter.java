package eu.telecomnancy.sensor;

public class Adapter extends LegacyTemperatureSensor implements ISensor {
	
	private double value;

	public void on() {
		if (!getStatus()) {
			onOff();
			try {
				update();
			} catch (SensorNotActivatedException e) {
				e.printStackTrace();
			}
		}
	}

	public void off() {
		if (getStatus()) {
			onOff();
		}
	}

	public void update() throws SensorNotActivatedException {
        if (getStatus())
        	value = getTemperature();
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
	}

	public double getValue() throws SensorNotActivatedException {
		if (getStatus())
			return value;
		else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}

}
