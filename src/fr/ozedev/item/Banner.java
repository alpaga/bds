package fr.ozedev.item;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class Banner {
	public static ItemStack getBanner(){
		ItemStack banner 					= new ItemStack(Material.BANNER,1);
		BannerMeta bannerMeta 				= (BannerMeta) banner.getItemMeta();
		bannerMeta.setBaseColor(DyeColor.WHITE);
		bannerMeta.setDisplayName("§r§aChoisir Team");
		banner.setItemMeta(bannerMeta);
		return banner;
	}
}
