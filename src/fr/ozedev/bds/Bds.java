package fr.ozedev.bds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import fr.ozedev.item.ChooseMap;
import fr.ozedev.item.Money;
import fr.ozedev.listener.InventoryClick;
import fr.ozedev.listener.OnDamage;
import fr.ozedev.listener.OnDamageByEntity;
import fr.ozedev.listener.OnMove;
import fr.ozedev.listener.PlayerDropItem;
import fr.ozedev.listener.PlayerInteract;
import fr.ozedev.listener.PlayerJoin;
import fr.ozedev.listener.PlayerRespawn;

public class Bds extends JavaPlugin{
	
	private static Map<String, BdsPlayer> bdsPlayer 		= new HashMap<>();
	private static FileConfiguration config;
	public static int compteur										= 60;
	public static Plugin instance;
	public static boolean gameStart										= false;
	public static int map;
	
	public void onEnable(){
		//mise en place des listener
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new InventoryClick() ,this);
		pm.registerEvents(new OnDamage(), this);
		pm.registerEvents(new PlayerRespawn(), this);
		pm.registerEvents(new PlayerDropItem(), this);
		pm.registerEvents(new OnMove(), this);
		pm.registerEvents(new OnDamageByEntity(), this);
		
		//mise en place de la config
		config = getConfig();
		instance = this;
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
		
		if(Bds.gameStart == false){
			// ajout de la banniere
			
			player.getInventory().clear();
			player.getInventory().addItem(ChooseMap.getChooseMap());
			
			// teleport aux lobby du jeux
			
			//set le game mode
			
			player.setGameMode(GameMode.ADVENTURE);
			
			if(Bukkit.getOnlinePlayers().size() >= 2){
				startGame();
			}
		}else{
			player.sendMessage("§b[Bds] §a La partie a déjà commencer");
			player.setGameMode(GameMode.SPECTATOR);
		}
		
		Location lobbyJeux = new Location(player.getWorld(),config.getInt("lobby.x"),config.getInt("lobby.y"),config.getInt("lobby.z"));
		
		player.teleport(lobbyJeux);
		
	}
	
	private static void startGame(){
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(instance, new Runnable(){
            @Override
            public void run() {
            	if(compteur > 0 && Bukkit.getOnlinePlayers().size() >= 2){
            		if(compteur == 60 || compteur == 30 || compteur == 15 || compteur == 10 || compteur <= 5) Bukkit.broadcastMessage("§b[Bds] §aLe jeu commence dans §c"+compteur+" §a seconde(s)");
            		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	                scheduler.scheduleSyncDelayedTask(instance, this, 20L);
	                compteur --;
            	}else if(compteur <= 0){
            		Iterator<? extends Player> iterator = Bukkit.getOnlinePlayers().iterator();
            		
            		int voteForGrand= 0;
            		int voteForPetit = 0;
            		
            		gameStart = true;
            		
            		int i = 0;
            		
            		
            		while(iterator.hasNext()){
            			Player player = iterator.next();
            			BdsPlayer BdsPlayer = Bds.get(player);
            			if(BdsPlayer.getVote() == 0) voteForGrand++;
            			else if(BdsPlayer.getVote() == 1) voteForPetit++;
            		}
            		
            		if(voteForPetit > voteForGrand){
            			Bukkit.broadcastMessage("§b[Bds] §aLa map choisie est §aPetit");
            			Bds.map = 1;
            		}
            		else{
            			Bukkit.broadcastMessage("§b[Bds] §aLa map choisie est §cGrand");
            			Bds.map = 0;
            		}
            		
            		Iterator<? extends Player> iterator2 = Bukkit.getOnlinePlayers().iterator();
            		
            		String[] team = {"Mauve","Orange","Vert","Cyan"};
            		
            		Location[] loc = {new Location(Bukkit.getWorld("world"), config.getInt("mauve.x"),config.getInt("mauve.y"),config.getInt("mauve.z")),new Location(Bukkit.getWorld("world"), config.getInt("orange.x"),config.getInt("orange.y"),config.getInt("orange.z")),new Location(Bukkit.getWorld("world"), config.getInt("vert.x"),config.getInt("vert.y"),config.getInt("vert.z")),new Location(Bukkit.getWorld("world"), config.getInt("cyan.x"),config.getInt("cyan.y"),config.getInt("cyan.z"))};
            		Location[] loc2 = {new Location(Bukkit.getWorld("world"), config.getInt("mauve2.x"),config.getInt("mauve2.y"),config.getInt("mauve2.z")),new Location(Bukkit.getWorld("world"), config.getInt("orange2.x"),config.getInt("orange2.y"),config.getInt("orange2.z")),new Location(Bukkit.getWorld("world"), config.getInt("vert2.x"),config.getInt("vert2.y"),config.getInt("vert2.z")),new Location(Bukkit.getWorld("world"), config.getInt("cyan2.x"),config.getInt("cyan2.y"),config.getInt("cyan2.z"))};
            		
            		while(iterator2.hasNext()){
            			Player player = iterator2.next();
            			BdsPlayer bdsPlayer = Bds.get(player);
            			
            			if(i >= 4) i = 0;
            			bdsPlayer.setTeam(team[i]);
            			player.sendMessage(bdsPlayer.getTeam());           			
            			if(voteForPetit> voteForGrand){
	            			player.teleport(loc[i]);
	            			get(player).setTeamLocation(loc[i]);
	            			i++;
            			}else{
            				player.teleport(loc2[i]);
	            			get(player).setTeamLocation(loc2[i]);
	            			i++;
            			}
            			bdsPlayer.setInGame(true);
            			player.getInventory().clear();
            			Bds.setDefaultInv(player);
            		}
            	}else{
            		Bukkit.broadcastMessage("§b[Bds]§a Un joueur viens de se déconnecter §c["+Bukkit.getOnlinePlayers().size() +"/20]§a, le compte a rebour est donc stopé");
            	}
            }
        }, 20L);
	}
	
	public static FileConfiguration useConfig(){
		return config;
	}
}
