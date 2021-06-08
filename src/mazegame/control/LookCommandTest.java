package mazegame.control;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.*;

public class LookCommandTest {

	 private ParsedInput inputCommand;
     private Player thePlayer;
     private CommandHandler handler;
     private LookCommand look;
     private Location gate,church;
     private ArrayList<String> dir;

     private Location field, shop;
     private HardCodedData hardCodedData;
     
	@Before
	public void setup(){
		 dir =new ArrayList();
		 dir.add("south");
		 hardCodedData = new HardCodedData();         
         inputCommand = new ParsedInput("look", dir);      
         thePlayer = new Player("Mike");
         gate = new Location("the main entrace", "gate");
         church = new Location("the place to worship", "church");
         gate.getDirections().addDirection("south", new Direction("shop", shop));
         church.getDirections().addDirection("north", new Direction("you see way to field", field));
         church.getInventory().addItem(new Weapon("khukuri",10,10,"knife"));
         thePlayer.setCurrentLocation(gate);
         handler = new CommandHandler();
         look = new LookCommand();	
	 
	}
	
	@Test
	public void testLookCommand() {
		 Assert.assertSame(gate, thePlayer.getCurrentLocation());
        
         CommandResponse response = look.execute(inputCommand, thePlayer);
         Assert.assertFalse(response.isFinishedGame());
        // Assert.assertTrue(response.getMessage().contains("If you want to move you need to tell me where."));
         Assert.assertSame(response.getMessage(),"shop");
	}

	
	
}