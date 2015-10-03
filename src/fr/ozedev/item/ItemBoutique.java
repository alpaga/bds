package fr.ozedev.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBoutique {
	public static ItemStack getOffensif(){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§r§6Objet Offensif");
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getDeffensif(){
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§r§6Objet Deffensif");
		item.setItemMeta(itemM);
		return item;
	}
}
