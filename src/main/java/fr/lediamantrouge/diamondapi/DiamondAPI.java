package fr.lediamantrouge.diamondapi;

import fr.lediamantrouge.diamondapi.chat.ChatManager;
import fr.lediamantrouge.diamondapi.database.DataBaseManager;
import fr.lediamantrouge.diamondapi.gameplay.GamePlayManager;
import fr.lediamantrouge.diamondapi.message.MessageManager;
import fr.lediamantrouge.diamondapi.scoreboard.ScoreBoardManager;
import fr.lediamantrouge.diamondapi.tag.TagManager;
import lombok.Getter;

@Getter
public class DiamondAPI {

    private static DiamondAPI instance;

    DataBaseManager dataBaseManager = new DataBaseManager();
    ChatManager chatManager = new ChatManager();
    TagManager tagManager = new TagManager();
    ScoreBoardManager scoreBoardManager = new ScoreBoardManager();
    GamePlayManager gamePlayManager = new GamePlayManager();
    MessageManager messageManager = new MessageManager();

    public static DiamondAPI get() {
        if (DiamondAPI.instance == null) {
            DiamondAPI.instance = new DiamondAPI();
        }

        return instance;
    }
}
