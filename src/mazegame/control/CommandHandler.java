package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mazegame.entity.*;

import mazegame.entity.Player;


public class CommandHandler {
	private CommandState availableCommands;
	
	public CommandHandler () {
		availableCommands = new MovementState();
	}
	
	public CommandResponse processTurn (String userInput, Player thePlayer) {
		availableCommands = availableCommands.update(thePlayer);
		ParsedInput validInput = parse(userInput);
		Command theCommand = (Command) availableCommands.getCommand(validInput.getCommand());
		if (theCommand == null) {
			return new CommandResponse("Command not Available");
		}
		else {
			return theCommand.execute(validInput, thePlayer);
		}
	}
	
	private ParsedInput parse(String userInput) {
		Parser theParser = new Parser(availableCommands.getLabels());
		return theParser.parse(userInput);
	}
}

