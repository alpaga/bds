package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.ozedev.boutique.Boutique;
import fr.ozedev.item.ChooseMap;
import fr.ozedev.menu.ChooseMapMenu;

public class PlayerInteract implements Listener{
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		
		//si l'action est un clic droit
		if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
			//si l'item est est la banniere
			if(player.getItemInHand().getType().equals(Material.DOUBLE_PLANT)) new Boutique(player);
			if(player.getItemInHand().equals(ChooseMap.getChooseMap())) ChooseMapMenu.menu(player);
		}
		if(!player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
	}
}
