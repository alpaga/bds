package fr.ozedev.bds;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BdsPlayer {
	private Player		player;
	private int 		money			= 1;
	private boolean 	inGame			= false;
	private String		team;
	private Location	teamLocation;
	
	public BdsPlayer(Player player) {
		this.player = player;
	}
	public int  getMoney(){
		return money;
	}
	public void setMoney(){
		player.getInventory().remove(Material.GOLD_NUGGET);
	}
	public void setMoney(int money){
		this.money = money;
		player.getInventory().remove(Material.GOLD_NUGGET);
	}
	public String getTeam(){
		return team;
	}
	public void setTeam(String team){
		this.team = team;
	}
	public boolean getInGame(){
		return inGame;
	}
	public void setInGame(boolean inGame){
		this.inGame = inGame;
	}
	public Location getTeamLocation(){
		return teamLocation;
	}
	public void setTeamLocation(Location teamLocation){
		this.teamLocation = teamLocation;
	}
}
