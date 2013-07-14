package net.niccossystem.perfectarena.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Arena {

    private final List<Location> spawnPoints;
    private final String name;
    private final String description;
    private final List<Player> players;

    public Arena(List<Location> spawnPoints, String name, String description) {
        this.spawnPoints = spawnPoints;
        this.name = name;
        this.description = description;
        players = new ArrayList<Player>();
    }

    /**
     * Get the arena's name
     * 
     * @return the name of the arena
     */
    public String getName() {
        return name;
    }

    /**
     * Get the arena's description
     * 
     * @return the description of the arena
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the players currently in the arena
     * 
     * @return the arena's current players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Add a {@link Player} to the arena
     * 
     * @param player
     *            - The {@link Player} to add
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Remove a player from the arena
     * 
     * @param player
     */
    public void removePlayer(Player player) {
        players.remove(player);
        player.damage(Double.MAX_VALUE);
    }

    public Location getRandomSpawnPoint() {
        Location furthestSpawn = null;
        double distance = Double.MIN_VALUE;

        for (Location loc : spawnPoints) {
            double locDistance = Double.MAX_VALUE;

            for (Player p : players) {
                double playerDistance = loc.distance(p.getLocation());
                if (playerDistance < locDistance) {
                    locDistance = playerDistance;
                }
            }

            if (locDistance > distance) {
                distance = locDistance;
                furthestSpawn = loc;
            }
        }

        return furthestSpawn != null ? furthestSpawn : spawnPoints.get(new Random().nextInt(spawnPoints.size() - 1));
    }

}
