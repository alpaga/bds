package fr.ozedev.item;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Equipe {
	public static ItemStack getMauve(){
		ItemStack mauve = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta mauveMeta = (LeatherArmorMeta) mauve.getItemMeta();
		mauveMeta.setColor(Color.PURPLE);
		mauveMeta.setDisplayName("§r§5Mauve");
		mauve.setItemMeta(mauveMeta);
		return mauve;
	}
	public static ItemStack getOrange(){
		ItemStack orange = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta orangeMeta = (LeatherArmorMeta) orange.getItemMeta();
		orangeMeta.setColor(Color.ORANGE);
		orangeMeta.setDisplayName("§r§6Orange");
		orange.setItemMeta(orangeMeta);
		return orange;
	}
	public static ItemStack getCyan(){
		ItemStack cyan = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta cyanMeta = (LeatherArmorMeta) cyan.getItemMeta();
		cyanMeta.setColor(Color.AQUA);
		cyanMeta.setDisplayName("§r§3Cyan");
		cyan.setItemMeta(cyanMeta);
		return cyan;
	}
	public static ItemStack getVert(){
		ItemStack vert = new ItemStack(Material.LEATHER_HELMET);
		LeatherArmorMeta vertMeta = (LeatherArmorMeta) vert.getItemMeta();
		vertMeta.setColor(Color.GREEN);
		vertMeta.setDisplayName("§r§2Vert");
		vert.setItemMeta(vertMeta);
		return vert;
	}
}
