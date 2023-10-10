package fr.lediamantrouge.diamondapi.tag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TagManager {

    public void resetTag(Player player) {
        setTagPrefix(player, "§f");
        setTagSuffix(player, "§f");
    }

    public void setTagPrefix(Player player, String tag) {
        Bukkit.getScoreboardManager().getMainScoreboard().getTeam(getTeamName(player)).setPrefix(tag);
    }

    public void setTagSuffix(Player player, String tag) {
        Bukkit.getScoreboardManager().getMainScoreboard().getTeam(getTeamName(player)).setSuffix(tag);
    }

    public void registerTag(Player player) {
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        if(sb.getTeam(getTeamName(player)) != null) return;
        sb.registerNewTeam(getTeamName(player));
        Team team = sb.getTeam(getTeamName(player));
        team.setPrefix("§f");
        team.setSuffix("§f");
        team.addEntry(player.getName());
    }

    public void unRegisterTag(Player player) {
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        if(sb.getTeam(getTeamName(player)) == null) return;
        Team team = sb.getTeam(getTeamName(player));
        team.unregister();
    }

    public String getTeamName(Player player) {
        return player.getUniqueId().toString().substring(0, 10);
    }
}
