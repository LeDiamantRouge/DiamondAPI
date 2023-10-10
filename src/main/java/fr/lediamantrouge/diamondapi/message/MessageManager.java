package fr.lediamantrouge.diamondapi.message;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class MessageManager {

    public static String setMessageOnDeath(EntityDamageEvent.DamageCause damageCause, Player victim, Player killer) {
        switch (damageCause) {
            case FALL:
                if (killer != null) {
                    return victim.getName() + " §7est mort de chute par  " + killer.getName();
                } else {
                    return victim.getName() + " §7est mort de chute.";
                }
            case ENTITY_ATTACK:
                if (killer != null) {
                    return victim.getName() + " §7à été tué par  " + killer.getName();
                } else {
                    return victim.getName() + " §7est mort.";
                }
            case PROJECTILE:
                if (killer != null) {
                    return victim.getName() + " §7est mort d'une flèche de  " + killer.getName();
                } else {
                    return victim.getName() + " §7est mort d'une flèche.";
                }
            case ENTITY_EXPLOSION:
                if (killer != null) {
                    return victim.getName() + " §7est mort d'une TNT de  " + killer.getName();
                } else {
                    return victim.getName() + " §7est mort d'une TNT.";
                }
            default:
                if (killer != null) {
                    return victim.getName() + " §7à été tué par " + killer.getName();
                } else {
                    return victim.getName() + " §7est mort.";
                }
        }
    }

    public static String getColorByNumber(int n) {
        switch (n) {
            case 4: return "§e";
            case 3: return "§6";
            case 2: return "§c";
            case 1: return "§4";
            default: return "§a";
        }
    }

    public static String centerText(String text) {
        int maxWidth = 60;
        int spaces = (int) Math.round((maxWidth - 1.4 * ChatColor.stripColor(text).length()) / 2);

        return StringUtils.repeat(" ", spaces) + text;
    }

    public static String secondsToFormatMinute(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
