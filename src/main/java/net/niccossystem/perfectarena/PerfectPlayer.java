package net.niccossystem.perfectarena;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.niccossystem.perfectarena.arena.PvPArena;
import net.niccossystem.perfectarena.perfectclass.PerfectClass;

public class PerfectPlayer {

	private final String player;
    private PerfectClass currentClass;
    private PvPArena currentArena;
    private int kills;
    private int deaths;
    private int pvpDeaths;
	
	public PerfectPlayer(Player p) {
		player = p.getName();
	}
    
    public void setCurrentArena(PvPArena a) {
    	currentArena = a;
    }
    
    public void setPerfectClass(PerfectClass c) {
    	currentClass = c;
    }
    
    public void setKills(int k) {
    	kills = k;
    }
    
    public void setDeaths(int d) {
    	deaths = d;
    }
    
    public void setPvpDeaths(int p) {
    	pvpDeaths = p;
    }
    
    public Player getPlayer() {
    	return Bukkit.getServer().getPlayer(player);
    }
    
    public PvPArena getCurrentArena() {
        return currentArena;
    }

    public PerfectClass getPerfectClass() {
        return currentClass;
    }
    
    public int getKills() {
    	return kills;
    }
    
    public int getDeaths() {
    	return deaths;
    }
    
    public int getPvpDeaths() {
    	return pvpDeaths;
    }
}
