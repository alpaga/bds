package fr.ozedev.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDeffensif {
	public static ItemStack[] getCoeurAride(){
		ItemStack item[] = {new ItemStack(Material.GOLD_CHESTPLATE),new ItemStack(Material.GOLD_LEGGINGS),new ItemStack(Material.GOLD_BOOTS)};
		ItemMeta itemM = item[0].getItemMeta();
		itemM.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
		itemM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		itemM.addEnchant(Enchantment.THORNS, 2, true);
		itemM.setDisplayName("§r§6Coeur Aride");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 5€");
		itemM.setLore(prix);
		for(int i = 0; i<item.length;i++) item[i].setItemMeta(itemM);
		return item;
	}
	public static ItemStack[] getNormalM(){
		ItemStack item[] = {new ItemStack(Material.CHAINMAIL_CHESTPLATE),new ItemStack(Material.CHAINMAIL_LEGGINGS),new ItemStack(Material.CHAINMAIL_BOOTS)};
		ItemMeta itemM = item[0].getItemMeta();
		itemM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		itemM.setDisplayName("§r§6Armure Amélioré");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 2€");
		itemM.setLore(prix);
		for(int i = 0; i<item.length;i++) item[i].setItemMeta(itemM);
		return item;
	}
	public static ItemStack[] getEcailleDeDragon(){
		ItemStack item[] = {new ItemStack(Material.IRON_CHESTPLATE),new ItemStack(Material.IRON_LEGGINGS),new ItemStack(Material.IRON_BOOTS)};
		ItemMeta itemM = item[0].getItemMeta();
		itemM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		itemM.setDisplayName("§r§6Ecaille De Dragon");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 12€");
		itemM.setLore(prix);
		for(int i = 0; i<item.length;i++) item[i].setItemMeta(itemM);
		return item;
	}
	public static ItemStack[] getArmureDArchimage(){
		ItemStack item[] = {new ItemStack(Material.DIAMOND_CHESTPLATE),new ItemStack(Material.DIAMOND_LEGGINGS),new ItemStack(Material.DIAMOND_BOOTS)};
		ItemMeta itemM = item[0].getItemMeta();
		itemM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		itemM.setDisplayName("§r§6Armure d'Archimage");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 15€");
		itemM.setLore(prix);
		for(int i = 0; i<item.length;i++) item[i].setItemMeta(itemM);
		return item;
	}
}
