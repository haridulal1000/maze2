package mazegame.entity;

public class Direction {
	private String description;
	private Location destination;
	
	public Direction (String description, Location destination)
	{
		this.setDescription(description);
		this.setDestination(destination);
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
