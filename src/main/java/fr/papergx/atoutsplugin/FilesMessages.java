package fr.papergx.atoutsplugin;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class FilesMessages {
    public FilesMessages(AtoutsPlugin main) {
        File file = new File(main.getDataFolder(), "messages.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        HashMap<String, String> listMessage = main.getListMessage();

        listMessage.put("noPermission", yamlConfiguration.getString("message.nopermission").replace("&", "§"));

        main.setListMessage(listMessage);
    }
}
