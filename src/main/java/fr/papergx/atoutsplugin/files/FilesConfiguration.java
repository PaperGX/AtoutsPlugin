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
        HashMap<String,String> listOtherConfig = main.getListOtherConfig();

        listPermission.put("staffAtout", yamlConfiguration.getString("permission.staffattout"));
        listOtherConfig.put("MainGuiName", yamlConfiguration.getString("gui.main.name"));
        listOtherConfig.put("ItemNoFallName", yamlConfiguration.getString("item.nofall.name"));

        main.setListPermission(listPermission);
        main.setListOtherConfig(listOtherConfig);

    }


}
