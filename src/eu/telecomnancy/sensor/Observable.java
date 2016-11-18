package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.Observer;

public interface Observable {
	
    /**
     * Attach an observer to the subject.
     */
	public void attach(Observer o);
	
    /**
     * Detach an observer from the subject.
     */
	public void detach(Observer o);
	
    /**
     * Notify its observer of a value change.
     */
	public void notifyObserver();

}
