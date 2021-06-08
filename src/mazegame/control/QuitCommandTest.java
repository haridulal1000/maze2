package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

public class QuitCommandTest {

	 private ParsedInput inputCommand;
     private Player thePlayer;
     private CommandHandler handler;
     private MoveCommand move;
     private Location gate,church;

     private Location field, shop;
     private HardCodedData hardCodedData;
     private QuitCommand quit;
     
	@Before
	public void setup(){
		 hardCodedData = new HardCodedData();         
         inputCommand = new ParsedInput("move", new ArrayList());      
         thePlayer = new Player("Mike");
         gate = new Location("the main entrace", "gate");
         church = new Shop("the place to worship", "church");
         gate.getDirections().addDirection("south", new Direction("you see way to shop to east", shop));
         church.getDirections().addDirection("north", new Direction("you see way to field", field));
         church.getInventory().addItem(new Weapon("khukuri",10,10,"knife"));
         thePlayer.setCurrentLocation(gate);
         handler = new CommandHandler();
         move = new MoveCommand();	
         quit=new QuitCommand();
	}
	
	@Test
	public void testQuit() {
		ParsedInput ip=new ParsedInput();
		ip.setCommand("quit");
		 CommandResponse cr=quit.execute(inputCommand, thePlayer);
		 Assert.assertSame(cr.getMessage(), "Thanks for playing MazeGame. See you soon.");
	}
	
	@Test
	public void testQuitStatus() {
		ParsedInput ip=new ParsedInput();
		ip.setCommand("quit");
		
		 CommandResponse response = move.execute(inputCommand, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
	}

	
	
}