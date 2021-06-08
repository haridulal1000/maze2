package mazegame.entity;

import java.util.HashMap;
import mazegame.entity.utility.*;

public class Location {

	private NonPlayerCharacterCollection characters;
	private Inventory items;
	private Directions directions;
	private String description;
	private String label;
	
	public Location () {
		directions = new Directions();
		items = new Inventory();
		characters = new NonPlayerCharacterCollection();
	}
	
	public Location (String description, String label){
		this();		
		this.setDescription(description);
		this.setLabel(label);
	}
	

	
	public Inventory getInventory () {
		return items;
	}
	

	
	public Directions getDirections () {
		return directions;
	}
		
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}	
	
	

    public String toString()
    {
        return "**********\n" + this.label + "\n**********\n"
            + "Directions found :: " + directions.availableDirections() + "\n**********\n"
            +"\n NPC Found :: "+ characters + "\n ****** \n"
            + "\n" + items.toString()
            + this.description + "\n**********\n";
    }
//for non character player
	public NonPlayerCharacterCollection getCharacters() {
		return characters;
	}

	public void setCharacters(NonPlayerCharacterCollection characters) {
		this.characters = characters;
	}


}
