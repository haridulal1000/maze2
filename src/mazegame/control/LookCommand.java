package mazegame.control;

import mazegame.entity.Direction;
import mazegame.entity.Player;
import mazegame.entity.Directions;

public class LookCommand implements Command {
	
	private CommandResponse response;
	
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		response = new CommandResponse("Can't find that to look at here!");
		if(userInput.getArguments().size() == 0) {
			response.setMessage(thePlayer.getCurrentLocation().toString());
			return response;
		}
		for (Object argument: userInput.getArguments()) {
			if (thePlayer.getCurrentLocation().getDirections().containsDirection(argument.toString())) {
				Direction theDirection = thePlayer.getCurrentLocation().getDirections().getDirection((String)argument);
				return new CommandResponse(theDirection.getDescription());
			}
		}
		return response;
	}
	
}
