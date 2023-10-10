package fr.lediamantrouge.diamondapi.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import fr.mrmicky.fastboard.FastBoardBase;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Getter
public class ScoreBoardManager {

    int refreshTime = 1;

    HashMap<UUID, FastBoard> scoreBoards = new HashMap<>();

    public FastBoard getScoreBoard(Player player) {
        return scoreBoards.get(player.getUniqueId());
    }

    public void registerPlayer(Player player, String title, String... lines) {
        if (scoreBoards.containsKey(player.getUniqueId())) return;
        FastBoard sb = scoreBoards.put(player.getUniqueId(), new FastBoard(player));
        if (sb == null) return;
        sb.updateTitle(title);
        sb.updateLines(lines);
    }

    public void unRegisterPlayer(Player player) {
        if (!scoreBoards.containsKey(player.getUniqueId())) return;
        scoreBoards.remove(player.getUniqueId());
    }

    public void setTitle(Player player, String title) {
        if (!scoreBoards.containsKey(player.getUniqueId())) return;
        scoreBoards.get(player.getUniqueId()).updateTitle(title);
    }

    public void setLines(Player player, String... lines) {
        if (!scoreBoards.containsKey(player.getUniqueId())) return;
        scoreBoards.get(player.getUniqueId()).updateLines(lines);
    }
}
