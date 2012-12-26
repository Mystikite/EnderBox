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
        // Create the Listener
        new EnderBoxListener(this);

        // Load the recipe??
        this.loadRecipes(); 
    }
 
    @Override
    public void onDisable() {
     
    	// disable the recipe
    	Bukkit.resetRecipes();
    	
    }

    public boolean isEnderBox(ItemStack item) {
    	boolean isEB = false;
    	
    	if (item != null) {
    		String name1 = item.getItemMeta().getDisplayName();
            List<String> lore1 = item.getItemMeta().getLore();

            if (name1 == null || lore1 == null) {
            	return isEB;
            }
            
            if (item.getType().equals(this.BOX) && name1.equals(this.BOX_NAME) && lore1.equals(this.BOX_LORE)) {
            	isEB = true;
            }
       	}
       		
		return isEB;
    }
    
    public void loadRecipes() {
    	
    	// define the item
    	ItemStack box = new ItemStack(BOX, 1);
    	
	    ItemMeta meta = (ItemMeta) box.getItemMeta();
	    meta.setDisplayName(BOX_NAME);
    	meta.setLore(BOX_LORE);
	    box.setItemMeta(meta);

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