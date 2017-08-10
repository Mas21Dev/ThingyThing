package ex.spork.core.API.Methods;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Message {

    private String BROADCAST = "§bBroadcast §8➢ §7";
    private String ALERT = "§c§lALERT §8➢ §7";
    private String SYSTEM = "§6System §8➢ §7";
    private String EAC = "§5E§fAC §8➢ §c";

    public String broadcast(String message) {
        Bukkit.broadcastMessage(BROADCAST + message);
        return message;
    }

    public String sendChat(String message) {
        Bukkit.broadcastMessage(message);
        return message;
    }

    public String message(CommandSender sender, String message) {
        sender.sendMessage(message);
        return message;
    }

    public String sendStaffMessage(String message) {
        Bukkit.broadcast(message, "essentials.alert");
        return message;
    }

    public String sendSystemAlert(String message, boolean staff) {
        if(staff) {
            Bukkit.broadcast(SYSTEM + message, "essentials.alert");
        } else {
            Bukkit.broadcastMessage(SYSTEM + message);
        }
        return message;
    }

    public String sendEACAlert(String message) {
        Bukkit.broadcast(EAC + message, "eac.alert");
        return message;
    }

    public String sendAlert(String message, boolean staff) {
        if(staff) {
            Bukkit.broadcast(ALERT + message, "essentials.alert");
        } else {
            Bukkit.broadcastMessage(ALERT + message);
        }
        return message;
    }

    public String incorrectUsage(CommandSender sender, String usage) {
        sender.sendMessage("§cIncorrect usage! Usage: " + usage);
        return usage;
    }

    public void noPermission(CommandSender sender) {
        sender.sendMessage("§cSorry, but you don't have permission to execute this command!");
    }

    public void sendConsoleError() {
        Bukkit.getConsoleSender().sendMessage("You must be a player to execute this command!");
    }

    public void error(CommandSender sender) {
        sender.sendMessage("§cError: §eThere has been an error. Please contact an administrator.");
    }
}
