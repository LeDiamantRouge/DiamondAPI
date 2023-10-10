package fr.lediamantrouge.diamondapi.tag;

import fr.lediamantrouge.diamondapi.DiamondAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TagListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        DiamondAPI.get().getTagManager().registerTag(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        DiamondAPI.get().getTagManager().unRegisterTag(e.getPlayer());
    }
}
