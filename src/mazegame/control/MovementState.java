package mazegame.control;

import mazegame.entity.Blacksmith;
import mazegame.entity.Player;
import mazegame.entity.Shop;

public class MovementState extends CommandState {
    public MovementState()
    {
        this.getAvailableCommands().put("go", new MoveCommand());
        this.getAvailableCommands().put("quit", new QuitCommand());
        this.getAvailableCommands().put("move", new MoveCommand());
        this.getAvailableCommands().put("get", new GetCommand());
        this.getAvailableCommands().put("look", new LookCommand());
        this.getAvailableCommands().put("list", new ListCommand());
        this.getAvailableCommands().put("attack", new AttackCommand());
        this.getAvailableCommands().put("status", new StatusCommand());
        this.getAvailableCommands().put("help", new HelpCommand());
        this.getAvailableCommands().put("talk", new TalkCommand());
    }

    public CommandState update(Player thePlayer)
    {
        if (thePlayer.getCurrentLocation() instanceof Shop)
            return new Transaction();
        return this;
    }
}
