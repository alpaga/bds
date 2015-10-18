package fr.ozedev.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChooseMap {
	public static ItemStack getChooseMap(){
		ItemStack item = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§r§6Choisie ta map !");
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getGrandMap(){
		ItemStack item = new ItemStack(Material.REDSTONE);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§r§6Grande Map");
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getPetitMap(){
		ItemStack item = new ItemStack(Material.REDSTONE,2);
		ItemMeta itemM = item.getItemMeta();
		itemM.setDisplayName("§r§6Petite Map");
		item.setItemMeta(itemM);
		return item;
	}
}
