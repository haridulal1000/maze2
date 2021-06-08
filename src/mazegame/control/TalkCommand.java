package mazegame.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import mazegame.entity.NonPlayerCharacter;
import mazegame.entity.Player;

public class TalkCommand implements Command{
	List<String> enemy;
	List<String> friend;
	
	public TalkCommand() {
		enemy=new ArrayList();
		enemy.add("I will kill you");
		enemy.add("You shall die");
		enemy.add("Prepare for war");
		
		friend=new ArrayList();
		friend.add("Hello Friend");
		friend.add("How are you?");
		friend.add("Hope you have a good day");
		
		
	}

	@Override
	public CommandResponse execute(ParsedInput userInput, Player thePlayer) {
		// TODO Auto-generated method stub
		String cmd;
		try {
		if(thePlayer.getCurrentLocation().getCharacters().size()!=0) {
			String arg= (String) userInput.getArguments().get(0);
			if (arg==null) {
				return new CommandResponse("Mention the name of the character as well");
			}
			
			 boolean value=thePlayer.getCurrentLocation().getCharacters().get(arg).getHostile();
			
			if(value) {
				Random r=new Random();
				
			cmd=this.enemy.get(r.nextInt(3));
			return new CommandResponse(cmd);
			}
		else { 
			Random r=new Random();
			
			cmd=this.friend.get(r.nextInt(3));
			return new CommandResponse(cmd);
		}
	}
		else {
		return new CommandResponse("There is no character to talk to");
	}

}
	
	catch(Exception e) {
		return new CommandResponse("Error in command");
	}
}
}
