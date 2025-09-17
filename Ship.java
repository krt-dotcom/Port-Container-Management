package portContainerManagement;

public class Ship {

	    private String name;
	    private String captain;

	    public Ship(String name, String captain) {
	        this.name = name;
	        this.captain = captain;
	    }

	    public String toString() {
	        return name + " | Capt. " + captain;
	    }
	    
}
