package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;
import mazegame.entity.Shop;

public class Transaction extends CommandState {

    public Transaction()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("buy", new BuyCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        
        this.getAvailableCommands().put("sell", new SellCommand());
        this.getAvailableCommands().put("list", new ListCommand());
        this.getAvailableCommands().put("get", new GetItem());
        this.getAvailableCommands().put("drop", new DropCommand());
        
        this.getAvailableCommands().put("status", new StatusCommand());
        this.getAvailableCommands().put("equip", new EquipCommand());
        this.getAvailableCommands().put("unequip", new UnequipCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Shop)
            return this;
        return new MovementState();
    }
}

