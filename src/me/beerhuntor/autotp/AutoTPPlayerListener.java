package me.beerhuntor.autotp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class AutoTPPlayerListener implements Listener {

 public AutoTP plugin;

  public AutoTPPlayerListener(AutoTP instance)
  {
    this.plugin = instance;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event)
  {
    Player player = event.getPlayer();
    String name = event.getPlayer().getName();

    if (event.getBucket() == Material.LAVA_BUCKET)
    {
      event.setCancelled(true);
      player.updateInventory();
      player.sendMessage(ChatColor.RED + "You are not allowed to place Lava on this server. Authorities have been notified.");
     
      
      this.plugin.logMessage(player.getName() + " has tried to place a Lava Bucket!");
    }

    for (Player onlinePlayers : this.plugin.getServer().getOnlinePlayers())
      if (onlinePlayers.hasPermission("AutoTP.Allow"))
      {
        onlinePlayers.sendMessage(ChatColor.RED + name + " has been a Lava Bucket.");
        onlinePlayers.teleport(player);
      }
  }
}