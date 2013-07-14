package net.niccossystem.perfectarena.serialize;

import java.util.HashMap;
import java.util.Map;
import net.niccossystem.perfectarena.PerfectArena;
import net.niccossystem.perfectarena.player.PerfectPlayer;
import org.bukkit.entity.Player;

public class PerfectPlayerSerializer {
    
    private final PerfectArena plugin;
    
    public PerfectPlayerSerializer(PerfectArena instance) {
        plugin = instance;
    }

    public Map<String, String> serialize(PerfectPlayer player) {
        Map<String, String> attributes = new HashMap<String, String>();

        String pClass = player.getPerfectClass().getName();
        String kills = String.valueOf(player.getKills());
        String deaths = String.valueOf(player.getDeaths());
        String pvpDeaths = String.valueOf(player.getPvpDeaths());

        attributes.put("Class", pClass);
        attributes.put("Kills", kills);
        attributes.put("Deaths", deaths);
        attributes.put("PvPKills", pvpDeaths);

        return attributes;
    }

    public PerfectPlayer deserialize(Player player, Map<String, String> attributes) {
        PerfectPlayer deserializedPlayer = new PerfectPlayer(player);

        deserializedPlayer.setPerfectClass(plugin.getClassHandler().getClassByName(attributes.get("Class")));
        deserializedPlayer.setKills(Integer.parseInt(attributes.get("Kills")));
        deserializedPlayer.setDeaths(Integer.parseInt(attributes.get("Deaths")));
        deserializedPlayer.setPvpDeaths(Integer.parseInt(attributes.get("PvPKills")));

        return deserializedPlayer;
    }
}
