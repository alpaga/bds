package fr.ozedev.bds;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.ozedev.item.Banner;
import fr.ozedev.item.Money;
import fr.ozedev.listener.InventoryClick;
import fr.ozedev.listener.OnDamage;
import fr.ozedev.listener.OnDamageByEntity;
import fr.ozedev.listener.PlayerDropItem;
import fr.ozedev.listener.PlayerInteract;
import fr.ozedev.listener.PlayerJoin;
import fr.ozedev.listener.PlayerRespawn;
import fr.ozedev.listener.onMove;

public class Bds extends JavaPlugin{
	
	private static Map<String, BdsPlayer> bdsPlayer 		= new HashMap<>();
	private static FileConfiguration config;
	
	public void onEnable(){
		//mise en place des listener
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new InventoryClick() ,this);
		pm.registerEvents(new OnDamage(), this);
		pm.registerEvents(new PlayerRespawn(), this);
		pm.registerEvents(new PlayerDropItem(), this);
		pm.registerEvents(new onMove(), this);
		pm.registerEvents(new OnDamageByEntity(), this);
		
		//mise en place de la config
		config = getConfig();
	}
	
	public static BdsPlayer get(Player player){
		return bdsPlayer.get(player.getName());
	}
	
	public static void setDefaultInv(Player player){
		player.getInventory().clear();
		player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS,1));
		player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS,1));
		player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE,1));
		player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET,1));
		player.getInventory().addItem(new ItemStack(Material.IRON_SWORD,1));
		setMoney(player);
	}
	
	public static void setMoney(Player player){
		player.getInventory().addItem(Money.getMoney(get(player).getMoney()));
	}
	
	public static void initPlayer(Player player){
		// init du BdsPlayer
		
		bdsPlayer.put(player.getName(), new BdsPlayer(player));
		
		// ajout de la banniere
		
		player.getInventory().clear();
		player.getInventory().addItem(Banner.getBanner());
		
		// teleport aux lobby du jeux
		
		Location lobbyJeux = new Location(player.getWorld(),config.getInt("lobby.x"),config.getInt("lobby.y"),config.getInt("lobby.z"));
		
		player.teleport(lobbyJeux);
		
		//set le game mode
		
		player.setGameMode(GameMode.ADVENTURE);
	}
	public static FileConfiguration useConfig(){
		return config;
	}
	
	public static void setLocationOnTeam(Player player, String string) {
		if (string.equals("§r§5Mauve")){
			get(player).setTeam("Mauve");
			get(player).setTeamLocation(new Location(player.getWorld(), config.getInt("mauve.x"),config.getInt("mauve.y"),config.getInt("mauve.z")));
			player.teleport(get(player).getTeamLocation());
		}
		if (string.equals("§r§6Orange")){
			get(player).setTeam("Orange");
			get(player).setTeamLocation(new Location(player.getWorld(), config.getInt("orange.x"),config.getInt("orange.y"),config.getInt("orange.z")));
			player.teleport(get(player).getTeamLocation());
		}
		if (string.equals("§r§3Cyan")){
			get(player).setTeam("Cyan");
			get(player).setTeamLocation(new Location(player.getWorld(), config.getInt("cyan.x"),config.getInt("cyan.y"),config.getInt("cyan.z")));
			player.teleport(get(player).getTeamLocation());
		}
		if (string.equals("§r§2Vert")){
			get(player).setTeam("Vert");
			get(player).setTeamLocation(new Location(player.getWorld(), config.getInt("vert.x"),config.getInt("vert.y"),config.getInt("vert.z")));
			player.teleport(get(player).getTeamLocation());
		}
	}
}
