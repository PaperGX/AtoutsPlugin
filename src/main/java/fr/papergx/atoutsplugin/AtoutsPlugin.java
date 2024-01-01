package fr.papergx.atoutsplugin;

import fr.papergx.atoutsplugin.atouts.CommandAtouts;
import fr.papergx.atoutsplugin.files.FilesConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class AtoutsPlugin extends JavaPlugin {

    private HashMap<String, String> listPermission;
    private HashMap<String, String> listMessage;

    @Override
    public void onEnable() {

        // - Create Hashmap

        this.listPermission = new HashMap<>();
        this.listMessage = new HashMap<>();

        // - Save Files

        this.saveResource("messages.yml", false);
        this.saveResource("configuration.yml", false);

        // - Load Files yml

        new FilesConfiguration(this);
        new FilesMessages(this);

        // - Command Manager

        getCommand("atouts").setExecutor(new CommandAtouts(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // - Getter


    public HashMap<String, String> getListMessage() {
        return listMessage;
    }

    public HashMap<String, String> getListPermission() {
        return listPermission;
    }

    // - Setter


    public void setListMessage(HashMap<String, String> listMessage) {
        this.listMessage = listMessage;
    }

    public void setListPermission(HashMap<String, String> listPermission) {
        this.listPermission = listPermission;
    }
}
