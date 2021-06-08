package mazegame.control;

import mazegame.entity.Direction;
import mazegame.entity.Player;
import mazegame.entity.Directions;


public class MoveCommand implements Command{

	public CommandResponse execute (ParsedInput userInput, Player thePlayer) {
		if (userInput.getArguments().size() == 0) {
			return new CommandResponse ("If you want to move you need to tell me where.");
		}
		String exitLabel = (String) userInput.getArguments().get(0);
   	 	Direction desiredDirection = thePlayer.getCurrentLocation().getDirections().getDirection(exitLabel);
   	 	if (desiredDirection == null) {
   	 		return new CommandResponse("There is no exit there . . . try moving somewhere else!");
   	 	}
   	 	thePlayer.setCurrentLocation(desiredDirection.getDestination());
   	 	return new CommandResponse("You have moved to " + exitLabel + " and successfully arrived here\n\n" + thePlayer.getCurrentLocation().toString());
	}


}
