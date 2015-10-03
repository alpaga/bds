package fr.ozedev.boutique;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.ItemBoutique;

public class Boutique {
	public Boutique(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Boutique");
		setInv(inv);
		player.openInventory(inv);
	}
	public void setInv(Inventory inv){
		inv.setItem(1, ItemBoutique.getDeffensif());
		inv.setItem(0, ItemBoutique.getOffensif());
	}
}
