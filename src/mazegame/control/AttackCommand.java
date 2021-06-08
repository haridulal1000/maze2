package mazegame.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mazegame.entity.Player;

public class AttackCommand implements Command {
	public CommandResponse execute (ParsedInput input, Player thePlayer) {
		
		// thePlayer.getCurrentLocation().getCharacters()
		List<String> arg=input.getArguments();
		String cmd;
			try {		
				String name=thePlayer.getCurrentLocation().getCharacters().get(arg.get(0)).getName();
				if(thePlayer.getCurrentLocation().getCharacters().get(arg.get(0)).getHostile()) {
					cmd="You attacked......."+thePlayer.getCurrentLocation().getCharacters().get(arg.get(0)).getName();
					thePlayer.getCurrentLocation().getCharacters().clear();
				}
				else {
				cmd=thePlayer.getCurrentLocation().getCharacters().get(arg.get(0)).getName()+" is a friend\n";
				}
				
			}catch(Exception e) {
				cmd="command error";
			}
		
		return new CommandResponse (cmd);
	}

}

