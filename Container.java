package portContainerManagement;

public class Container {

	    private String id;
	    private String description;
	    private String weight;

	    public Container(String id, String description, String weight) {
	        this.id = id;
	        this.description = description;
	        this.weight = weight;
	    }

	    public String toString() {
	        return id + " | " + description + " | " + weight;
	    }
	
}
