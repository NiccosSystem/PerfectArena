package net.niccossystem.perfectarena.listener;

import net.niccossystem.perfectarena.PerfectArena;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final PerfectArena plugin;
    
    public PlayerQuitListener(PerfectArena instance) {
        plugin = instance;
    }
    
    public void onPlayerQuit(PlayerQuitEvent e) {
        
    }
}
