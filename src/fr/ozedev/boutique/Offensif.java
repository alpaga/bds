package fr.ozedev.boutique;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.ozedev.bds.Bds;
import fr.ozedev.item.ItemOffensif;

public class Offensif {
	static Material sword[] = {Material.DIAMOND_SWORD,Material.GOLD_SWORD,Material.IRON_SWORD,Material.STONE_SWORD,Material.WOOD_SWORD};
	public Offensif(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Offensif");
		setInv(inv);
		player.openInventory(inv);
	}
	public void setInv(Inventory inv){
		inv.setItem(0, ItemOffensif.getFlamboyance());
		inv.setItem(1, ItemOffensif.getEcailleDeDragon());
		inv.setItem(2, ItemOffensif.getLameMana());
		inv.setItem(3, ItemOffensif.getNormaleM());
		inv.setItem(4, ItemOffensif.getRepousseVent());
	}
	public static void click(Player player, ItemStack item) {
		if((item.equals(ItemOffensif.getEcailleDeDragon())) && (Bds.get(player).getMoney() >= 12)){
			for(int i = 0; i<sword.length; i++) player.getInventory().remove(sword[i]);
			player.getInventory().addItem(ItemOffensif.getEcailleDeDragon());
			Bds.get(player).setMoney(Bds.get(player).getMoney()-10);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemOffensif.getFlamboyance())) && (Bds.get(player).getMoney() >= 5)){
			for(int i = 0; i<sword.length; i++) player.getInventory().remove(sword[i]);
			player.getInventory().addItem(ItemOffensif.getFlamboyance());
			Bds.get(player).setMoney(Bds.get(player).getMoney()-5);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemOffensif.getLameMana())) && (Bds.get(player).getMoney() >= 10)){
			for(int i = 0; i<sword.length; i++) player.getInventory().remove(sword[i]);
			player.getInventory().addItem(ItemOffensif.getLameMana());
			Bds.get(player).setMoney(Bds.get(player).getMoney()-10);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemOffensif.getNormaleM())) && (Bds.get(player).getMoney() >= 2)){
			for(int i = 0; i<sword.length; i++) player.getInventory().remove(sword[i]);
			player.getInventory().addItem(ItemOffensif.getNormaleM());
			Bds.get(player).setMoney(Bds.get(player).getMoney()-2);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemOffensif.getRepousseVent())) && (Bds.get(player).getMoney() >= 5)){
			for(int i = 0; i<sword.length; i++) player.getInventory().remove(sword[i]);
			player.getInventory().addItem(ItemOffensif.getRepousseVent());
			Bds.get(player).setMoney(Bds.get(player).getMoney()-5);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}else{
			player.sendMessage("§aTu n'as pas asser de §6money");
		}
	}
}
