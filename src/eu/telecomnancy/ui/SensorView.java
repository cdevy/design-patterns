package eu.telecomnancy.ui;

import eu.telecomnancy.commands.GetSensorValue;
import eu.telecomnancy.commands.RoundSensorValue;
import eu.telecomnancy.commands.SwitchSensorScale;
import eu.telecomnancy.commands.TurnSensorOff;
import eu.telecomnancy.commands.TurnSensorOn;
import eu.telecomnancy.commands.UpdateSensor;
import eu.telecomnancy.sensor.DecoratorFahrenheit;
import eu.telecomnancy.sensor.DecoratorFahrenheitCreator;
import eu.telecomnancy.sensor.DecoratorRoundValue;
import eu.telecomnancy.sensor.DecoratorRoundValueCreator;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureScale;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SensorView extends JPanel implements Observer {
    private ISensor sensor;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");
    private JButton switchType = new JButton("Switch to °F");
    private JButton roundValue = new JButton("Round value");
    
    /* Commands */
    private TurnSensorOn turnOnCommand;
    private TurnSensorOff turnOffCommand;
    private UpdateSensor updateCommand;
    private SwitchSensorScale switchScaleCommand;
    private RoundSensorValue roundValueCommand;
    private GetSensorValue getValueCommand;

    public SensorView(ISensor c) {
        this.sensor = c;
        sensor.attach(this);
     
		DecoratorFahrenheitCreator creator1 = new DecoratorFahrenheitCreator();
		DecoratorFahrenheit decorator1 = (DecoratorFahrenheit) creator1.factoryMethod(c);
		DecoratorRoundValueCreator creator2 = new DecoratorRoundValueCreator();
		DecoratorRoundValue decorator2 = (DecoratorRoundValue) creator2.factoryMethod(c);
		
        turnOnCommand = new TurnSensorOn(sensor);
        turnOffCommand = new TurnSensorOff(sensor);
        updateCommand  = new UpdateSensor(sensor);
        switchScaleCommand = new SwitchSensorScale(decorator1);
        roundValueCommand = new RoundSensorValue(decorator2);
        getValueCommand = new GetSensorValue(sensor);
        
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);

        on.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
            	turnOnCommand.execute();
            	update();
            }
        });

        off.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	turnOffCommand.execute();
            	update();
            }
        });

        update.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	updateCommand.execute();
            }
        });
        
        switchType.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	switchScaleCommand.execute();
            	update();
            	
            	if (sensor.getScale().equals(TemperatureScale.CELSIUS)) {
            		switchType.setText("Switch to °F");
            	} else {
            		switchType.setText("Switch to °C");
            	}
            }
        });

        roundValue.addActionListener(new ActionListener() {
    
        	public void actionPerformed(ActionEvent e) {
            	roundValueCommand.execute();
            	update();
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
		getValueCommand.execute();
		value.setText(getValueCommand.display());
	}
}
