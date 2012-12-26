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

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();
        
        // Make sure we are using our object.     
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && item != null && plugin.isEnderBox(item)) {
 
            e.setCancelled(true);   // Always cancel the event to prevent normal interaction

            // Open the inventory for the player
            player.openInventory(player.getEnderChest());
        }
	}
}

