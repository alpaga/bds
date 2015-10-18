package fr.ozedev.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.ozedev.bds.Bds;

public class OnMove implements Listener{
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		player.setSaturation(20);
		
		int bx = player.getLocation().getBlockX();
		int by = player.getLocation().getBlockY();
		int bz = player.getLocation().getBlockZ();
		
		if((by>=31 && by<=33 && bx<=1356 && bx>=1346 && bz<= 219 && bz>=202) && !Bds.get(player).getTeam().equals("Mauve")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10, 3));
			player.sendMessage("§b[Bds] §aTu n'as pas le droit d'aller dans le §chome§a des autres");
		}
		if((by>=31 && by<=33 && bx>=1421 && bx<=1431 && by>=202 && by<=219) && !Bds.get(player).getTeam().equals("Orange")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10, 3));
			player.sendMessage("§b[Bds] §aTu n'as pas le droit d'aller dans le §chome§a des autres");
		}
		if((by>=31 && by<=33 && bz>=243 && bz<=253 && bx<=1397 && bx>=1380) && !Bds.get(player).getTeam().equals("Vert")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10, 3));
			player.sendMessage("§b[Bds] §aTu n'as pas le droit d'aller dans le §chome§a des autres");
		}
		if((by>=31 && by<=33 && bz<=178 && bz>=168 && bx>=1380 && bx<=1397) && !Bds.get(player).getTeam().equals("Cyan")){
			player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 10, 3));
			player.sendMessage("§b[Bds] §aTu n'as pas le droit d'aller dans le §chome§a des autres");
		}
	}
}
