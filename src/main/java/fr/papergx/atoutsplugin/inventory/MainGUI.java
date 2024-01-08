package fr.papergx.atoutsplugin.inventory;

import dev.jcsoftware.minecraft.gui.GUI;
import fr.papergx.atoutsplugin.AtoutsPlugin;
import fr.papergx.atoutsplugin.other.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MainGUI extends GUI<AtoutsPlugin> {
    private AtoutsPlugin main;
    public MainGUI(AtoutsPlugin main) {
        super(main);
        this.main = main;
        createInventory();
    }

    public void createInventory() {

        HashMap<String, String> listOtherConfig = main.getListOtherConfig();

        set(11, new ItemBuilder(Material.FEATHER)
                .setName(listOtherConfig.get("ItemNoFallName").replace("&", "§"))
                .toItemStack());
    }

    @Override
    public int getSize() {
        return 36;
    }

    @Override
    public String getTitle() {
        return main.getListOtherConfig().get("MainGuiName").replace("&", "§");
    }

    @Override
    public boolean canClose(Player player) {
        return true;
    }
}
