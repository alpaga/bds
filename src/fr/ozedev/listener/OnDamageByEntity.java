package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.ozedev.bds.Bds;
import fr.ozedev.bds.BdsPlayer;

public class OnDamageByEntity implements Listener {
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent  event){
		
		//si c'est un joueur qui a taper
	    if ((event.getDamager() instanceof Player )&&(event.getEntity() instanceof Player) && Bds.gameStart == true){
	    	BdsPlayer damager = Bds.get((Player) event.getDamager());
	    	BdsPlayer victime = Bds.get((Player) event.getEntity());
	    	
	    	
	    	//Si ils sont dans la m§me team
	    	if(damager.getTeam().equals(victime.getTeam())){
	    		event.setCancelled(true);
	    		event.getDamager().sendMessage("§aLe joueur §b"+event.getEntity().getName().toString()+"§a est dans votre team impossible de le taper");
	    	}
	    }
	    else{
	    	event.setCancelled(true);
	    }
	}
}
