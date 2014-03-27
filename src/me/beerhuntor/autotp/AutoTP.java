/*
* author of this plugin is BeerHuntor.  All code is considered open source. 
*/

package me.BeerHuntor.AutoTP;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoTP extends JavaPlugin
{

private Logger log = Logger.getLogger("Minecraft");

  public void onEnable() {
    //PluginManager pm = getServer().getPluginManager();
      
      logMessage("is loading... ");

    //pm.registerEvent(Event.Type.BLOCK_PLACE, this.blockListener, Event.Priority.Normal, this);
   // pm.registerEvent(Event.Type.PLAYER_BUCKET_EMPTY, this.playerListener, Event.Priority.Normal, this);
   // pm.registerEvent(Event.Type.PLAYER_INTERACT_ENTITY, this.entityListener, Event.Priority.Normal, this);
getServer().getPluginManager().registerEvents((new AutoTPBlockListener(this)), this);
//getServer().getPluginManager().registerEvents((new AutoTPEntityListener(this)), this);
getServer().getPluginManager().registerEvents((new AutoTPPlayerListener(this)), this);


    logMessage(" Has been enabled!");
  }

  public void onDisable()
  {
    logMessage("is shutting down....");
    logMessage(" Has been disabled!");
  }

  protected void logMessage(String msg) {
    PluginDescriptionFile pdFile = getDescription();
    this.log.info("[" + pdFile.getName() + "] " + "Version " + pdFile.getVersion() + ":" + msg);
  }
}