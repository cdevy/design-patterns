package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.Decorator;
import eu.telecomnancy.sensor.DecoratorFahrenheit;
import eu.telecomnancy.sensor.DecoratorRoundValue;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SensorView extends JPanel implements Observer {
    private ISensor sensor;
    private Decorator typeDecorator;
    private Decorator roundDecorator;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
    private JButton switchType = new JButton("Switch to °F");
    private JButton roundValue = new JButton("Round value");
    
    private TemperatureScale scale; 

    public SensorView(ISensor c) {
        this.sensor = c;
        sensor.attach(this);
        
        typeDecorator = new DecoratorFahrenheit(sensor);
        scale = ((DecoratorFahrenheit) typeDecorator).getScale();
        
        roundDecorator = new DecoratorRoundValue(sensor);
        
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
                typeDecorator.on();
            }
        });

        off.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	typeDecorator.off();
            }
        });

        update.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                	typeDecorator.update();
                	roundValue.setEnabled(true);
                } catch (SensorNotActivatedException sensorNotActivatedException) {
                    sensorNotActivatedException.printStackTrace();
                }
            }
        });
        
        switchType.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	double oldValue;
            	if (value.getText().contains("N/A")) {
            		oldValue = -1;
            	} else {
            		oldValue =  Double.parseDouble(value.getText().substring(0, value.getText().length()-3));
            	}
            	double newValue = ((DecoratorFahrenheit) typeDecorator).switchType(oldValue);
            	scale = ((DecoratorFahrenheit) typeDecorator).getScale();
            	if (scale.equals(TemperatureScale.CELSIUS)) {
            		if (newValue != -1) {
            			value.setText(newValue + "°C");
            		} else {
            			value.setText("N/A °C");
            		}	
            		switchType.setText("Switch to °F");
            	} else {
            		if (newValue != -1) {
            			value.setText(newValue + "°F");
            		} else {
            			value.setText("N/A °F");
            		}
            		switchType.setText("Switch to °C");
            	}
            	roundValue.setEnabled(true);
            }
        });

        roundValue.addActionListener(new ActionListener() {
    
        	public void actionPerformed(ActionEvent e) {
            	if (!value.getText().contains("N/A")) {
            		double oldValue =  Double.parseDouble(value.getText().substring(0, value.getText().length()-3));
            		String s = ((DecoratorRoundValue) roundDecorator).round(oldValue);
                	if (scale.equals(TemperatureScale.CELSIUS)) {
                		value.setText(s + " °C");
                	} else {
                		value.setText(s + " °F");
                	}
                	roundValue.setEnabled(false);
            	}
        	}
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        
        JPanel buttonsPanel2 = new JPanel();
        buttonsPanel2.setLayout(new GridLayout(2, 1));
        buttonsPanel2.add(switchType);
        buttonsPanel2.add(roundValue);
        
        this.add(buttonsPanel2, BorderLayout.EAST);
    }

	public void update() {
		try {
			String s = "" + typeDecorator.getValue();
			if (scale.equals(TemperatureScale.CELSIUS)) {
    			s += " °C";
    		} else {
    			s += " °F";
    		}
			value.setText(s);
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
}
