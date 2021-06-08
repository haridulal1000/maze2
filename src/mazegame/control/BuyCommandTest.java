package mazegame.control;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mazegame.HardCodedData;
import mazegame.entity.Direction;
import mazegame.entity.Directions;
import mazegame.entity.Location;
import mazegame.entity.Player;
import mazegame.entity.Shop;
import mazegame.entity.Weapon;

public class BuyCommandTest {

	private ParsedInput playerInput;
    private Player thePlayer;
    private CommandHandler handler;
    private BuyCommand buy;

    private Weapon m5, rpg;
    private Location startUp;
    private Shop bestFirearm;
    private HardCodedData hd;
    public BuyCommandTest() {
    	
    }
    
	@Before
	public void setup(){
		 hd = new HardCodedData();         
        playerInput = new ParsedInput("buy", new ArrayList());      
        thePlayer = new Player("greg");
        startUp=new Location();
        m5 = new Weapon("m5", 25, 6,"m5"); 
        rpg=new Weapon("rpg",20,5,"rpg");
        bestFirearm = new Shop("shop", "shop");
       
        startUp.getInventory().addItem(m5);
		bestFirearm.getInventory().addItem(rpg);
        
        
		bestFirearm.getInventory().addItem(new Weapon("rpg",10,10,"gun"));
        
        thePlayer.setCurrentLocation(startUp);
        handler = new CommandHandler();
        buy = new BuyCommand();		
        startUp.getDirections().addDirection("east", new Direction("bestFirearm",bestFirearm));
        }
	
	
	
	@Test
	public void testBuyWeapon() {
		 Assert.assertSame(startUp, thePlayer.getCurrentLocation());
		 thePlayer.setCurrentLocation(bestFirearm);
        // test move command no exit
        CommandResponse response = buy.execute(playerInput, thePlayer);
        Assert.assertFalse(response.isFinishedGame());
      //  Assert.assertTrue(response.getMessage().contains("You Have successfully bought"+m5.getLabel()));
        Assert.assertSame(bestFirearm, thePlayer.getCurrentLocation());
	}

}
