package fr.ozedev.menuEquipe;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import fr.ozedev.item.Equipe;

public class MenuEquipe {
	public MenuEquipe(Player player){
		Inventory inv = Bukkit.createInventory(player, 9, "Equipe");
		setInv(inv);
		player.openInventory(inv);
	}
	private void setInv(Inventory inv){
		inv.setItem(0, Equipe.getMauve());
		inv.setItem(1, Equipe.getOrange());
		inv.setItem(2, Equipe.getCyan());
		inv.setItem(3, Equipe.getVert());
	}
}
