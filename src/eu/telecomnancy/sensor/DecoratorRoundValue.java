package eu.telecomnancy.sensor;

import java.text.NumberFormat;

public class DecoratorRoundValue extends Decorator {
	
	NumberFormat numberFormat = NumberFormat.getInstance(java.util.Locale.ENGLISH);
	
	public DecoratorRoundValue(ISensor sensor) {
		super(sensor);
		numberFormat.setMaximumFractionDigits(2);
	}
	
	public void round() {
		try {
			setValue(Double.parseDouble(numberFormat.format(getValue())));
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
}
