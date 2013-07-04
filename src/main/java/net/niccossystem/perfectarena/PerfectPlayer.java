package net.niccossystem.perfectarena;

import net.niccossystem.perfectarena.arena.PvPArena;
import net.niccossystem.perfectarena.perfectclass.PerfectClass;


public class PerfectPlayer {
    private PerfectClass currentClass;
    private PvPArena currentArena;
    
    
    public PvPArena getCurrentArena() {
        return currentArena;
    }
    
    public PerfectClass getPerfectClass() {
        return currentClass;
    }
}
