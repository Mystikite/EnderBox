package net.voodoohq.mystikite.EnderBox;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class EnderBoxListener implements Listener {
    private EnderBox plugin;

    public EnderBoxListener(EnderBox plugin) {
    	plugin.getServer().getPluginManager().registerEvents(this, plugin);
    	this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        
        // Make sure we are using our object.     
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && item != null &&
        		item.getType().equals(plugin.BOX)) {

            String name1 = item.getItemMeta().getDisplayName();
            List<String> lore1 = item.getItemMeta().getLore();
     
            if (name1.equals(plugin.BOX_NAME) && lore1.equals(plugin.BOX_LORE)) {
 
            	e.setCancelled(true);   // Always cancel the event to prevent normal interaction

            	// Open the inventory for the player
            	player.openInventory(player.getEnderChest());
            }
        }
    }
}
