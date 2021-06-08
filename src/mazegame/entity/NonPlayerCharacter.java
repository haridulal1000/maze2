package mazegame.entity;

public class NonPlayerCharacter extends Character {
	private Boolean hostile;
	private Location location;
	private String name;

    public NonPlayerCharacter(String name)
    {
    	this.name=name;
    }
    public String getName() {
    	return this.name;
    }

    public boolean getHostile () {
    	return this.hostile;
    }
    
    public void setHostile (boolean hostile) {
    	this.hostile = hostile;
    }
    public void setLocation(Location location) {
    	this.location=location;
    }
    public Location getLocation() {
    	return this.location;
    }
}
