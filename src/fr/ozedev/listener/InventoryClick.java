package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.ozedev.bds.Bds;
import fr.ozedev.boutique.Deffensif;
import fr.ozedev.boutique.Offensif;
import fr.ozedev.item.ItemBoutique;

public class InventoryClick implements Listener{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();
		//si l'inventaire ou l'on a clické est est l'equipe
		if(event.getInventory().getName().toString().equals("Equipe")){
			//on donne l'inventaire
			Bds.setDefaultInv(player);
			//et on teleport
			Bds.setLocationOnTeam(player, event.getCurrentItem().getItemMeta().getDisplayName().toString());
			//et on le met en mode in game
			Bds.get(player).setInGame(true);
		}
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
		if(!player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
	}
}
