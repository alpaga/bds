package fr.ozedev.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.ozedev.boutique.Boutique;
import fr.ozedev.item.Banner;
import fr.ozedev.menuEquipe.MenuEquipe;

public class PlayerInteract implements Listener{
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		
		//si l'action est un clic droit
		if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
			//si l'item est est la banniere
			if(player.getItemInHand().equals(Banner.getBanner())){
				//on ouvre le menu de choix d'équipe
				new MenuEquipe(player);
			}
			if(player.getItemInHand().getType().equals(Material.DOUBLE_PLANT)) new Boutique(player);
		}
		if(!player.getGameMode().equals(GameMode.CREATIVE)) event.setCancelled(true);
	}
}
