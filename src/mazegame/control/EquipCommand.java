package mazegame.control;


import mazegame.entity.Item;
import mazegame.entity.Player;

public class EquipCommand implements Command {
	public CommandResponse execute (ParsedInput input, Player thePlayer) {
		return new CommandResponse ("You entered the equip command");
}


}
