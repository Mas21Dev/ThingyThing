import ex.spork.core.API.Methods.Message;
import ex.spork.core.API.Methods.Network;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Message message;
    private static Network network;

    @Override
    public void onEnable() {

        message = new Message();
        network = new Network();
    }

    public static Message getMessage() {
        return message;
    }

    public static Network getNetwork() {
        return network;
    }


}
