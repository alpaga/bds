package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import fr.ozedev.bds.Bds;

public class OnDamage implements Listener{
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		//si l'entité est un joueur
		if (event.getEntity() instanceof Player){
			Player player = (Player) event.getEntity();
			//si il est tomber ou qu'il est dans le lobby
			if((event.getCause().equals(DamageCause.FALL)) || (Bds.get(player).getInGame() == false)){
				//on annule les dégat
				event.setCancelled(true);
			}
		}
	}
}
