package me.beerhuntor.autotp; 

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class AutoTPBlockListener implements Listener{
public AutoTP plugin;

  public AutoTPBlockListener(AutoTP instance)
  {
    this.plugin = instance;
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onBlockPlace(BlockPlaceEvent event){

    Block block = event.getBlock();
    Player player = event.getPlayer();
    String name = event.getPlayer().getName();

    if (block.getType() == Material.TNT)
    {
      event.setCancelled(true);
      player.updateInventory();
      player.sendMessage(ChatColor.RED + "You are not allowed to place TNT on this server. Authorities have been notified!");

      this.plugin.logMessage(name + " has placed a TnT block at X" + block.getX() + ": Y" + block.getY() + ": Z" + block.getZ());

      for (Player onlinePlayers : this.plugin.getServer().getOnlinePlayers()) {
        if (onlinePlayers.hasPermission("AutoTP.Allow")) {
          onlinePlayers.sendMessage(ChatColor.RED + name + " has placed a TnT Block!");
          onlinePlayers.teleport(player);
        }
      }
    }

    if (block.getType() == Material.FIRE)
    {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + "You are not allowed to place Fire on this server. Authorities have been notified!");

      this.plugin.logMessage(name + " has placed a Fire block at X" + block.getX() + ": Y" + block.getY() + ": Z" + block.getZ());

      for (Player onlinePlayers : this.plugin.getServer().getOnlinePlayers()) {
        if (onlinePlayers.hasPermission("AutoTP.Allow")) {
          onlinePlayers.sendMessage(ChatColor.RED + name + " has placed a Fire Block!");
          onlinePlayers.teleport(player);
        }
      }
    }

    if (block.getType() == Material.LAVA)
    {
      event.setCancelled(true);
      player.sendMessage(ChatColor.RED + "You are not allowed to place Lava source blocks on this server. Authorities have been notified!");

      this.plugin.logMessage(name + " has placed a Lava block at X" + block.getX() + ": Y" + block.getY() + ": Z" + block.getZ());

      for (Player onlinePlayers : this.plugin.getServer().getOnlinePlayers())
        if (onlinePlayers.hasPermission("AutoTP.Allow")) {
          onlinePlayers.sendMessage(ChatColor.RED + name + " has placed a Lava Block");
          onlinePlayers.teleport(player);
        }
    }
  }

}