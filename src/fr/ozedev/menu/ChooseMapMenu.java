package fr.ozedev.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import fr.ozedev.item.ChooseMap;

public class ChooseMapMenu {
	public static void menu(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Choisi ta map");
		setInv(inv);
		player.openInventory(inv);
	}
	private static void setInv(Inventory inv){
		inv.setItem(0, ChooseMap.getGrandMap());
		inv.setItem(1, ChooseMap.getPetitMap());
	}
}
