package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.ozedev.bds.Bds;
import fr.ozedev.boutique.Deffensif;
import fr.ozedev.boutique.Offensif;
import fr.ozedev.item.ChooseMap;
import fr.ozedev.item.ItemBoutique;

public class InventoryClick implements Listener{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		if(event.getInventory().getName().toString().equals("Boutique")){ 
			if(event.getCurrentItem().equals(ItemBoutique.getOffensif())) new Offensif(player);
			if(event.getCurrentItem().equals(ItemBoutique.getDeffensif())) new Deffensif(player);
		}
		if(event.getInventory().getName().toString().equals("Deffensif")){
			Deffensif.click(player, event.getCurrentItem());
		}
		if(event.getInventory().getName().toString().equals("Offensif")){
			Offensif.click(player, event.getCurrentItem());
		}
		if(event.getCurrentItem().equals(ChooseMap.getGrandMap())){
			Bds.get(player).setVote(0);
		}
		if(event.getCurrentItem().equals(ChooseMap.getPetitMap())){
			Bds.get(player).setVote(1);
		}
		if(!player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
	}
}
