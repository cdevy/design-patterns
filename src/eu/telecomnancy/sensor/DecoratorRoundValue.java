package eu.telecomnancy.sensor;

import java.text.NumberFormat;

public class DecoratorRoundValue extends Decorator {
	
	NumberFormat numberFormat = NumberFormat.getInstance(java.util.Locale.ENGLISH);
	
	public DecoratorRoundValue(ISensor sensor) {
		super(sensor);
	}
	
	public String round(double oldValue) {
		numberFormat.setMaximumFractionDigits(2);
		return numberFormat.format(oldValue);
	}
}
