package mazegame.entity;

import java.util.HashMap;
import mazegame.entity.Direction;

public class Directions {
	private HashMap <String, Direction>directions;
	
	public Directions () {
		directions = new HashMap<String, Direction> ();
	}
	
	public boolean addDirection (String directionLabel, Direction theDirection) {
		if (directions.containsKey(directionLabel))
			return false;
		directions.put(directionLabel, theDirection);
		return true;
	}

	public Direction getDirection (String directionLabel) {
		return (Direction) directions.get(directionLabel);
	}
	
	public boolean containsDirection (String directionLabel) {
		return directions.containsKey(directionLabel);
	}
	
	public String availableDirections () {
		StringBuilder returnMsg = new StringBuilder();
		for (Object label: this.directions.keySet()) {
			returnMsg.append("[ " + label.toString() + " ]");
		}
		return returnMsg.toString();
	}
}
