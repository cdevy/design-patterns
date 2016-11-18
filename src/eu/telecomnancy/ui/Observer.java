package eu.telecomnancy.ui;

public interface Observer {
	
    /**
     * Tell the observer to update its state 
     * so it would be consistent with the subject's state.
     */
	public void update();

}
