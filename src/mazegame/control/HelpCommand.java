package mazegame.control;

import mazegame.entity.Player;

public class HelpCommand implements Command{

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		// TODO Auto-generated method stub
		
		String cmd= "Here is the list of Commands:\n"+
					"go\n"+
					"quit\n"+
					"move\n"+
					"get\n"+
					"look\n"+
					"list\n"+
					"attack\n"+
					"status\n"+
					"talk\n"+
					"help";
		
		
		return new CommandResponse(cmd);
	}

}
