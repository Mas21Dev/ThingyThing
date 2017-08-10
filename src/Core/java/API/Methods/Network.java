package ex.spork.core.API.Methods;

import Main;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Network {

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");

    Date time = new Date();
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    BanList nameBan = Bukkit.getBanList(BanList.Type.NAME);
    BanList ipBan = Bukkit.getBanList(BanList.Type.IP);


    public void banPlayer(CommandSender sender, Player target, String reason) {
        BanEntry ban = nameBan.getBanEntry(target.getName());
        nameBan.addBan(target.getName(), reason, null, sender.getName());

        if(target.hasPermission("essentials.bypass")) {
            Main.getMessage().message(sender, ChatColor.RED + "You can't ban that player!");
            return;
        }
        target.kickPlayer(
                "§cYou have been §4suspended §cfrom the §5Exedite §fNetwork \n" + "\n"
                        + "§7Reason §f" + reason + "\n"
                        + "§7Suspended By §c" + sender.getName() + "\n"
                        + "\n §cIf you would like to appeal, visit §7§n§owww.(yourwebsitehere).com");
        Main.getMessage().sendSystemAlert("§6" + target.getName() + " §7has been suspended.", true);
    }

    public void banPlayer(CommandSender sender, String target, String reason) {
        nameBan.addBan(target, reason, null, sender.getName());
        Main.getMessage().sendSystemAlert("§6" + target + " §7has been suspended by.", true);
    }

    public void banIP(CommandSender sender, String ip, String reason) {
        BanEntry ban = ipBan.getBanEntry(ip);
        ipBan.addBan(ip, reason, null, sender.getName());
        Main.getMessage().sendSystemAlert("§7An IP has been suspended.", true);

        for(Player online : Bukkit.getServer().getOnlinePlayers()) {
            if(online.getAddress().getAddress().getHostAddress().equals(ip)) {
                online.kickPlayer("§cYour IP has been §4suspended §cfrom the §5Exedite §fNetwork \n" + "\n"
                        + "§7Reason §f" + reason + "\n"
                        + "§7Suspended By §c" + sender.getName() + "\n"
                        + "\n §cIf you would like to appeal, visit §7§n§owww.(yourwebsitehere).com");
            }
        }
    }

    public void kickPlayer(CommandSender sender, Player target, String reason) {
        if(target.hasPermission("essentials.bypass")) {
            Main.getMessage().message(sender, ChatColor.RED + "You can't kick that player!");
            return;
        }
        target.kickPlayer(
                "§cYou have been §4kicked §cfrom the §6Exedite Network \n" + "\n"
                        + "§7Reason §f" + reason + "\n"
                        + "§7Kicked By §c" + sender.getName());

        Main.getMessage().sendSystemAlert("§6" + target.getName() + " §7has been kicked.", true);
    }

    public void eacKickPlayer(Player target, String reason) {
        target.kickPlayer(
                "§8» §5Expedite §fAntiCheat §8« \n" + "§cYou have been §4kicked §cfrom the §5Exedite §fNetwork \n" + "\n"
                        + "§7Reason §f" + reason);

        Main.getMessage().sendEACAlert("§6" + target.getName() + " §7has been kicked for: §c" + reason + ".");
    }

    public void tempbanPlayer(CommandSender sender, Player target, Date time, String reason) {
        BanList list = Bukkit.getBanList(BanList.Type.NAME);
        list.addBan(target.getName(), reason, time, sender.getName());

        if(target.hasPermission("essentials.bypass")) {
            Main.getMessage().message(sender, ChatColor.RED + "You can't ban that player!");
            return;
        }
        target.kickPlayer(
                "§cYou have been §4temp-suspended §cfrom the §5Exedite §fNetwork \n" + "\n"
                        + "§7Reason §f" + reason + "\n"
                        + "§7Suspended By §c" + sender.getName()
                        + ""
                        + "\n §cIf you would like to appeal, visit §7§n§owww.(yourwebsitehere).com");
        Main.getMessage().sendSystemAlert("§6" + target.getName() + " §7has been temp-suspended.", true);
    }

    public void tempbanPlayer(CommandSender sender, String target, Date time, String reason) {
        BanList list = Bukkit.getBanList(BanList.Type.NAME);

        list.addBan(target, reason, time, sender.getName());
        Main.getMessage().sendSystemAlert("§6" + target + " §7has been temp-suspended.", true);
    }

    public void logEAC(CheckResult checkResult, UserData userData) {
        Core.getMessageUtils().sendEACAlert("§6" + userData.getPlayer().getName()
                + " §7Level: §c" + checkResult.getLevel().toString().toLowerCase()
                + " §cType: §7" + checkResult.getType().getName()
                + " §cMessage: §f" + checkResult.getMessage());
    }
}
