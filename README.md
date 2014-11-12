Design Patterns Labs
=========

## Provided Java Code

This project provides few basic classes to be used during the "Design Pattern" labs.  


#### Core classes

`eu.telecomnancy.ISensor`: An interface that brand new sensor must implement.  
`eu.telecomnancy.SensorNotActivatedException`: An exception that is thrown when a sensor is not in the right mood ;)  
`eu.telecomnancy.TemperatureSensor`: An brand new temperature sensor implementing `ISensor` interface.  
`eu.telecomnancy.LegacyTemperatureSensor`: A old implementation of a temperature sensor.  

#### Command line client application

`eu.telecomnancy.App`: A basic command line interface (CLI) to control a temperature sensor (implementing `ISensor` interface).  
`eu.telecomnancy.ui.ConsoleUI`: A class that manages command line user interaction.  

#### Swing client application

`eu.telecomnancy.SwingApp`: A basic Swing application that displays a temperature sensor (implementing `ISensor` interface).  
`eu.telecomnancy.ui.SensorWindow`: A tiny sensor view that provides some basic controls.  
`eu.telecomnancy.ui.MainWindow`: The main window of the swing application that display only one sensor view.  

#### Helper Classes

`eu.telecomnancy.ReadPropertyFile`: A class to show how to read a property file in the class path

## UML Class Diagrams

#### Class diagram of the provided code

![UML class diagram of the provided code](https://bytebucket.org/telecomnancy-pcd/design-patterns-lab/raw/c75905ab438c893770f196fb18c57c1344877169/uml/class-diagram.png)

Please note that some elements appear to be attributes, but, in fact, they are preceded by a `P` icon indicating they are considered as properties (meaning a setter and a getter methods are provided). For instance, in the `ISensor` interface, there is a value property which means the interface provides `getValue()` et `setValue(double value)` methods but not necessary a `value` attribute.  

#### Class diagram of the legacy code to be integrated in your app

![UML class diagram of the legacy code to be integrated](https://bytebucket.org/telecomnancy-pcd/design-patterns-lab/raw/c75905ab438c893770f196fb18c57c1344877169/uml/legacy-class-diagram.png)