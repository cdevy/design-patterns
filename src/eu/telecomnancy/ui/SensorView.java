package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

@SuppressWarnings("serial")
public class SensorView extends JPanel implements Observer {
    private ISensor sensor;

    private JLabel value = new JLabel("N/A °C");
    private JButton on = new JButton("On");
    private JButton off = new JButton("Off");
    private JButton update = new JButton("Acquire");

    public SensorView(ISensor c) {
        this.sensor = c;
        sensor.attach(this);
        
        this.setLayout(new BorderLayout());

        value.setHorizontalAlignment(SwingConstants.CENTER);
        Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
        value.setFont(sensorValueFont);

        this.add(value, BorderLayout.CENTER);


        on.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
                sensor.on();
            }
        });

        off.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                sensor.off();
            }
        });

        update.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                try {
                    sensor.update();
                } catch (SensorNotActivatedException sensorNotActivatedException) {
                    sensorNotActivatedException.printStackTrace();
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(update);
        buttonsPanel.add(on);
        buttonsPanel.add(off);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

	public void update() {
		try {
		    NumberFormat numberFormat = NumberFormat.getInstance(java.util.Locale.FRENCH);
		    numberFormat.setMaximumFractionDigits(2);
			value.setText(numberFormat.format(sensor.getValue()) + " °C");
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
}
