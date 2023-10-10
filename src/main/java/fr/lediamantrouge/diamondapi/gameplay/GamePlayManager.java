package fr.lediamantrouge.diamondapi.gameplay;

import fr.lediamantrouge.diamondapi.Main;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class GamePlayManager {

    public static void respawnInstant(Player player) {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
            ((CraftPlayer) player).getHandle().playerConnection.a(packet);
        }, 1L);
    }
}
