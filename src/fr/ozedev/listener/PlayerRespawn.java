package fr.ozedev.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import fr.ozedev.bds.Bds;
import fr.ozedev.bds.BdsPlayer;

public class PlayerRespawn implements Listener{
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event){
		Player player = event.getPlayer();
		event.setRespawnLocation(Bds.get(player).getTeamLocation());
		
		//l'argent
		BdsPlayer bdsPlayer = Bds.get(player);
		BdsPlayer bdsKiller = Bds.get(player.getKiller());
		
		//on clear l'argent du killer
		
		player.getKiller().getInventory().remove(Material.DOUBLE_PLANT);
		
		if (bdsPlayer.getMoney() >= 1){
			bdsPlayer.setMoney(bdsPlayer.getMoney()-1);
		}
		bdsKiller.setMoney(bdsKiller.getMoney()+2);
		
		//le stuff pour le mort
		player.getInventory().clear();
		Bds.setDefaultInv(player);
		
		//le stuff pour le killer
		Bds.setMoney(player.getKiller());
	}
}
