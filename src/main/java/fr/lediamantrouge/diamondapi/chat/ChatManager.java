package fr.lediamantrouge.diamondapi.chat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ChatManager {

    String chatFormat = "<%player%> %message%";
    HashMap<UUID, String> playerFormat = new HashMap<>();

    public String getPlayerChatFormat(Player player, String message) {
        for (UUID uuid : playerFormat.keySet()) {
            Player player1 = Bukkit.getPlayer(uuid);
            if (player == player1) {
                return playerFormat.get(uuid).replace("%player%", player.getDisplayName()).replace("%message%", message);
            }
        }
        return chatFormat.replace("%player%", player.getDisplayName()).replace("%message%", message);
    }

    public void setChatFormat(String chatFormat) {
        this.chatFormat = chatFormat;
    }

    public void setPlayerFormat(Player player, String format) {
        if (format == null) {
            playerFormat.remove(player.getUniqueId());
        } else {
            playerFormat.put(player.getUniqueId(), format);
        }
    }
}
