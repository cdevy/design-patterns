package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureScale;

public class GetSensorValue implements Command {
	
	private ISensor sensor;
	private double value = -1;
	
	public GetSensorValue(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		if (sensor != null) {
			if (sensor.getStatus()) {
				try {
					value = sensor.getValue();
				} catch (SensorNotActivatedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String display() {
		if (sensor != null) {
			if (!sensor.getStatus()) {
				return "N/A °C";
			} else {
				if (sensor.getScale().equals(TemperatureScale.CELSIUS)) {
					return value + " °C";
			    } else {
			    	return value + " °F";
			    }
			}
		}
		return "N/A °C";
	}
}
