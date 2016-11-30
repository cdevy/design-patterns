package eu.telecomnancy.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eu.telecomnancy.helpers.ReadPropertyFile;
import eu.telecomnancy.sensor.DecoratorFahrenheit;
import eu.telecomnancy.sensor.DecoratorRoundValue;
import eu.telecomnancy.sensor.ISensor;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	
	private ReadPropertyFile properties = new ReadPropertyFile();
	private ISensor sensor;
	private HashMap<String,Command> list = new HashMap<String,Command>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Menu(ISensor s) {
		super();
		JMenu commands = new JMenu("Commands");
	    try {
			Properties p = properties.readFile("/eu/telecomnancy/commands/command.properties");
			sensor = s;
			for (String i: p.stringPropertyNames()) {
	            JMenuItem item = new JMenuItem(i);
				Class c = Class.forName(p.getProperty(i));
				Class[] types = new Class[]{ISensor.class};
				Constructor constructor = c.getConstructor(types);
				Command command;
				if (c.equals(SwitchSensorScale.class)) {
					command = (Command) constructor.newInstance(new DecoratorFahrenheit(s));
				} else if (c.equals(RoundSensorValue.class)) {
					command = (Command) constructor.newInstance(new DecoratorRoundValue(s));
				} else {
					command = (Command) constructor.newInstance(s);
				}
				list.put(item.getText(), command);
	            item.addActionListener(new ActionListener() {
	            	
	                public void actionPerformed(ActionEvent event) {
	                	JMenuItem item = (JMenuItem) event.getSource();
	                	Command command = list.get(item.getText());
	                	command.execute();
	                	if (!item.getText().equals("updateCommand")) {
	                		sensor.notifyObserver();
	                	}
	                }       
	            });
	            commands.add(item);
			}
	    } catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		    } catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		} catch (NoSuchMethodException e) {
		    e.printStackTrace();
		} catch (InvocationTargetException e) {
		    e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    this.add(commands);
	    setVisible(true);
	}
}
