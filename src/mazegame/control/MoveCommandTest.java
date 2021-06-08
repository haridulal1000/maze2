package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

public class MoveCommandTest {

	 private ParsedInput inputCommand;
     private Player thePlayer;
     private CommandHandler handler;
     private MoveCommand move;
     private Location gate,church;

     private Location field, shop;
     private HardCodedData hardCodedData;
     
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
	 
	}
	
	@Test
	public void testMoveNoWhere() {
		 Assert.assertSame(gate, thePlayer.getCurrentLocation());
        
         CommandResponse response = move.execute(inputCommand, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
         Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
         Assert.assertSame(gate, thePlayer.getCurrentLocation());
	}

	@Test
	public void testMoveNoDirection() {
		 Assert.assertSame(gate, thePlayer.getCurrentLocation());
		 
         
         CommandResponse response = move.execute(inputCommand, thePlayer);
         Assert.assertFalse(response.isFinishedGame());         
         Assert.assertSame(gate, thePlayer.getCurrentLocation());
	}
	
	
}