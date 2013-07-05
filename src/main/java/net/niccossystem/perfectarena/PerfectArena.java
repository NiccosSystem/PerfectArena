package net.niccossystem.perfectarena;

import java.util.ArrayList;
import java.util.List;
import net.niccossystem.perfectarena.arena.PvPArena;
import net.niccossystem.perfectarena.listener.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PerfectArena extends JavaPlugin {

    private final List<PvPArena> arenas = new ArrayList<PvPArena>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getLogger().info(getDescription().getName() + " version " + 
        		getDescription().getVersion() + " has been enabled");
    }

    @Override
    public void onDisable() {
    	getLogger().info(getDescription().getName() + " has been disabled");
    }

    public void removePlayer(Player player) {
        for (PvPArena arena : arenas) {
            if (!arena.getPlayers().contains(player)) {
                continue;
            }
            arena.removePlayer(player);
        }
    }
}
