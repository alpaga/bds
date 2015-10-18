package fr.ozedev.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.ozedev.bds.Bds;

public class PlayerJoin implements Listener{
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(Bds.gameStart == false)
			event.setJoinMessage("§b[Bds] §c"+player.getName()+"§a vient de se connecter §c["+Bukkit.getOnlinePlayers().size()+"/20]");
		else
			event.setJoinMessage("");
		Bds.initPlayer(player);
	}
}
