package mazegame.control;

import mazegame.entity.Item;
import mazegame.entity.Player;

public class UnequipCommand implements Command {
	public CommandResponse execute (ParsedInput input, Player thePlayer) {
		return new CommandResponse ("You entered the unequip command");
}


}
