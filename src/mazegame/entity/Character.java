package mazegame.entity;

public class Character {
	private int agility;
    private int lifePoints;
    private String name;
    private int strength;
    

    public Character()
    {
    }

    public Character(String name)
    {
        this.setName(name);
    }

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getStrength() {
		return strength;
	}

	private void setStrength(int strength) {
		this.strength = strength;
	}
}
