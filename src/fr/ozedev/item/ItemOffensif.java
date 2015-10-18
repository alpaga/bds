package fr.ozedev.item;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemOffensif {
	public static ItemStack getFlamboyance(){
		ItemStack item = new ItemStack(Material.GOLD_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
		itemM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		itemM.setDisplayName("§r§6Flamboyance");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 5§");
		itemM.setLore(prix);
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getRepousseVent(){
		ItemStack item = new ItemStack(Material.WOOD_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(Enchantment.KNOCKBACK, 3, true);
		itemM.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itemM.setDisplayName("§r§6Repousse-vent");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 5§");
		itemM.setLore(prix);
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getLameMana(){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itemM.setDisplayName("§r§6Lame De Mana");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 10§");
		itemM.setLore(prix);
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getNormaleM(){
		ItemStack item = new ItemStack(Material.IRON_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		itemM.setDisplayName("§r§6Epée amélioré");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 2§");
		itemM.setLore(prix);
		item.setItemMeta(itemM);
		return item;
	}
	public static ItemStack getEcailleDeDragon(){
		ItemStack item = new ItemStack(Material.STONE_SWORD);
		ItemMeta itemM = item.getItemMeta();
		itemM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		itemM.setDisplayName("§r§6Ecaille de dragon");
		ArrayList<String> prix = new ArrayList<String>();
		prix.add("Coute 12§");
		itemM.setLore(prix);
		item.setItemMeta(itemM);
		return item;
	}
}
