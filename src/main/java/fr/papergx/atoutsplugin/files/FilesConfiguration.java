package fr.papergx.atoutsplugin.files;

import fr.papergx.atoutsplugin.AtoutsPlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

public class FilesConfiguration {

    public FilesConfiguration(AtoutsPlugin main) {

        File file = new File(main.getDataFolder(), "messages.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        HashMap<String, String> listPermission = main.getListPermission();

        listPermission.put("staffAtout", yamlConfiguration.getString("permission.staffattout"));

        main.setListPermission(listPermission);

    }


}
