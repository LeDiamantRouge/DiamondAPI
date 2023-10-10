package fr.lediamantrouge.diamondapi;

import fr.lediamantrouge.diamondapi.chat.ChatListeners;
import fr.lediamantrouge.diamondapi.tag.TagListeners;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChatListeners(), this);
        pluginManager.registerEvents(new TagListeners(), this);
    }
}
