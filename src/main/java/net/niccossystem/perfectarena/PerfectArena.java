package net.niccossystem.perfectarena;

import java.util.ArrayList;
import java.util.List;
import net.niccossystem.perfectarena.arena.PvPArena;
import net.niccossystem.perfectarena.listener.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class PerfectArena extends JavaPlugin {

    private List<PvPArena> arenas = new ArrayList<PvPArena>();
    
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }
    
    @Override
    public void onDisable() {
        
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
