package fr.ozedev.boutique;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.ozedev.bds.Bds;
import fr.ozedev.item.ItemDeffensif;

public class Deffensif {	
	public Deffensif(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Deffensif");
		setInv(inv);
		player.openInventory(inv);
	}
	public void setInv(Inventory inv){
		inv.setItem(0, ItemDeffensif.getArmureDArchimage()[0]);
		inv.setItem(1, ItemDeffensif.getCoeurAride()[0]);
		inv.setItem(2, ItemDeffensif.getEcailleDeDragon()[0]);
		inv.setItem(3, ItemDeffensif.getNormalM()[0]);
	}
	public static void click(Player player, ItemStack item){
		if((item.equals(ItemDeffensif.getArmureDArchimage()[0])) && (Bds.get(player).getMoney() >= 10)){
			player.getInventory().setChestplate(ItemDeffensif.getArmureDArchimage()[0]);
			player.getInventory().setLeggings(ItemDeffensif.getArmureDArchimage()[1]);
			player.getInventory().setBoots(ItemDeffensif.getArmureDArchimage()[2]);
			Bds.get(player).setMoney(Bds.get(player).getMoney()-10);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemDeffensif.getEcailleDeDragon()[0])) && (Bds.get(player).getMoney() >= 12)){
			player.getInventory().setChestplate(ItemDeffensif.getEcailleDeDragon()[0]);
			player.getInventory().setLeggings(ItemDeffensif.getEcailleDeDragon()[1]);
			player.getInventory().setBoots(ItemDeffensif.getEcailleDeDragon()[2]);
			Bds.get(player).setMoney(Bds.get(player).getMoney()-12);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemDeffensif.getCoeurAride()[0])) && (Bds.get(player).getMoney() >= 5)){
			player.getInventory().setChestplate(ItemDeffensif.getCoeurAride()[0]);
			player.getInventory().setLeggings(ItemDeffensif.getCoeurAride()[1]);
			player.getInventory().setBoots(ItemDeffensif.getCoeurAride()[2]);
			Bds.get(player).setMoney(Bds.get(player).getMoney()-5);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}if((item.equals(ItemDeffensif.getNormalM()[0])) && (Bds.get(player).getMoney() >= 2)){
			player.getInventory().setChestplate(ItemDeffensif.getNormalM()[0]);
			player.getInventory().setLeggings(ItemDeffensif.getNormalM()[1]);
			player.getInventory().setBoots(ItemDeffensif.getNormalM()[2]);
			Bds.get(player).setMoney(Bds.get(player).getMoney()-2);
			player.getInventory().remove(Material.DOUBLE_PLANT);
			Bds.setMoney(player);
		}else{
			player.sendMessage("§aTu n'as pas asser de §6money");
		}
	}
}
