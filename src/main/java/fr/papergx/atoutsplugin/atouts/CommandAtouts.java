package fr.papergx.atoutsplugin.atouts;

import fr.papergx.atoutsplugin.AtoutsPlugin;
import fr.papergx.atoutsplugin.inventory.MainGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandAtouts implements CommandExecutor {

    private AtoutsPlugin main;
    public CommandAtouts(AtoutsPlugin atoutsPlugin) {
        this.main = atoutsPlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;

        if(strings.length == 0) {

            main.getGuiAPI().openGUI(player, new MainGUI(main));

            return false;
        }

        HashMap<String, String> listPermission = main.getListPermission();
        HashMap<String, String> listMessage = main.getListMessage();


        player.sendMessage(listPermission.get("staffAtout"));

        if(!player.hasPermission("c")) {
            player.sendMessage(listMessage.get("nopermission"));
            return false;
        }

        switch (strings[0].toLowerCase()) {
            case "help":

                player.sendMessage("§f§l§m----------------------------");
                player.sendMessage(" ");
                player.sendMessage(" §6§lAtoutsPlugin");
                player.sendMessage(" ");
                player.sendMessage(" §f§l➜ §e/atout give (pseudo) §7Give un atouts à un joueur");
                player.sendMessage(" §f§l➜ §e/atout reload §7Reload la configuration du plugin");
                player.sendMessage(" ");
                player.sendMessage("§f§l§m----------------------------");

                break;
        }


        return false;
    }
}
