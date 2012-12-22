package net.voodoohq.mystikite.EnderBox;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class EnderBox extends JavaPlugin {
 
	final Enchantment ENCHANT = Enchantment.SILK_TOUCH;
	final Material BOX = Material.ENDER_CHEST; 
	final Material EPEARL = Material.ENDER_PEARL; 
    final String BOX_NAME = ChatColor.GOLD + "Ender's Box";
    final List<String> BOX_LORE = Arrays.asList(ChatColor.ITALIC + "Go for whats in the box!");
	ShapelessRecipe BOX_RECIPE;
	
    @Override
    public void onEnable(){
        // Create the SampleBukkitPluginListener
        new EnderBoxListener(this);

        // Load the enderbox recipe??
        this.loadRecipes(); 
    }
 
    @Override
    public void onDisable() {
     
    	// disable the recipe
    	Bukkit.resetRecipes();
    	
    }

    public void loadRecipes() {
    	
    	// define the item
    	ItemStack box = new ItemStack(BOX, 1);
    	
    	box.addUnsafeEnchantment(ENCHANT, 1);
	    ItemMeta meta = (ItemMeta) box.getItemMeta();
	    meta.setDisplayName(BOX_NAME);
    	meta.setLore(BOX_LORE);
	    box.setItemMeta(meta);
	    box.removeEnchantment(ENCHANT);

	    // define the recipe.
        BOX_RECIPE = new ShapelessRecipe(box);
        BOX_RECIPE.addIngredient(8, EPEARL, -1);
        BOX_RECIPE.addIngredient(1, BOX);
        
        // add the recipe.
        Bukkit.addRecipe(BOX_RECIPE);
    	
    }
    
    
	public void log(Level level, String message) {
		Bukkit.getLogger().log(level, "[" + this.getName() + "] " + message);
	}
}