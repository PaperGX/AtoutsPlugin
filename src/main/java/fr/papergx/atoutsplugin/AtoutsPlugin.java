package fr.papergx.atoutsplugin;

import dev.jcsoftware.minecraft.gui.GUIAPI;
import fr.papergx.atoutsplugin.atouts.CommandAtouts;
import fr.papergx.atoutsplugin.files.FilesConfiguration;
import fr.papergx.atoutsplugin.files.FilesMessages;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

@Getter
public final class AtoutsPlugin extends JavaPlugin {

    @Setter
    private HashMap<String, String> listPermission;
    @Setter
    private HashMap<String, String> listMessage;
    @Setter
    private HashMap<String, String> listOtherConfig;


    private GUIAPI guiAPI;

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

        // - Gui

         this.guiAPI = new GUIAPI(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // - Getter


    // - Setter


}
