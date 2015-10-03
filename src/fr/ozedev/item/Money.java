package fr.ozedev.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Money {
	public static ItemStack getMoney(int nombre){
		ItemStack money = new ItemStack(Material.DOUBLE_PLANT,nombre);
		ItemMeta moneyMeta = money.getItemMeta();
		moneyMeta.setDisplayName("§6Money : "+nombre);
		moneyMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, nombre, true);
		money.setItemMeta(moneyMeta);
		return money;
	}
}
