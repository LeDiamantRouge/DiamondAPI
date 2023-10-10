package fr.lediamantrouge.diamondapi.chat;

import fr.lediamantrouge.diamondapi.DiamondAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListeners implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onChatEvent(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        Bukkit.broadcastMessage(DiamondAPI.get().getChatManager().getPlayerChatFormat(e.getPlayer(), e.getMessage()));
    }
}
