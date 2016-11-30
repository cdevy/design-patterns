package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.DecoratorFahrenheit;
import eu.telecomnancy.sensor.ISensor;

public class SwitchSensorScale implements Command {
	
	private ISensor sensor;
	
	public SwitchSensorScale(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		if (sensor != null) {
			((DecoratorFahrenheit) sensor).switchType();
		}
	}
}
