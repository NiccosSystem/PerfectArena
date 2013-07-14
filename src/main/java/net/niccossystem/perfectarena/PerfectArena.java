package net.niccossystem.perfectarena;

import java.util.ArrayList;
import java.util.List;
import net.niccossystem.perfectarena.arena.ArenaHandler;
import net.niccossystem.perfectarena.arena.Arena;
import net.niccossystem.perfectarena.listener.PlayerQuitListener;
import net.niccossystem.perfectarena.perfectclass.PerfectClassHandler;
import net.niccossystem.perfectarena.player.PerfectPlayerHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PerfectArena extends JavaPlugin {

    private final List<Arena> arenas = new ArrayList<Arena>();
    private final ArenaHandler arenaHandler;
    private final PerfectPlayerHandler playerHandler;
    private final PerfectClassHandler classHandler;
    
    public PerfectArena() {
        arenaHandler = new ArenaHandler(this);
        playerHandler = new PerfectPlayerHandler(this);
        classHandler = new PerfectClassHandler(this);
        
        getLogger().info("Loaded " + classHandler.getPerfectClasses().size() + " PerfectClasses from config");
    }
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(this), this);       
        
        getLogger().info(getDescription().getName() + " version " + getDescription().getVersion() + " has been enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled");
    }

    public void removePlayer(Player player) {
        for (Arena arena : arenas) {
            if (!arena.getPlayers().contains(player)) {
                continue;
            }
            arena.removePlayer(player);
        }
    }
    
    public ArenaHandler getArenaHandler() {
        return arenaHandler;
    }
    
    public PerfectPlayerHandler getPlayerHandler() {
        return playerHandler;
    }
    
    public PerfectClassHandler getClassHandler() {
        return classHandler;
    }
}
