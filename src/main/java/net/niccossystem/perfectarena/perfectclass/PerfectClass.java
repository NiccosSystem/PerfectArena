package net.niccossystem.perfectarena.perfectclass;

import java.util.HashMap;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;

public class PerfectClass {

    /**
     * The name and description of the class
     */
    private final String name;
    private final String description;

    /**
     * The class' armour
     */
    private ItemStack helmet;
    private ItemStack chest;
    private ItemStack legs;
    private ItemStack boots;

    /**
     * The class' itesm (Like sword, bow, arrows etc.)
     */
    private HashMap<Integer, ItemStack> items;

    /**
     * The class' potion effects
     */
    private List<PotionEffect> potionEffects;

    /**
     * Construct a PerfectClass
     * 
     * @param name
     *            - The name of the PerfectClass
     * @param description
     *            - The description of the PerfectClass
     */
    public PerfectClass(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Give the specified player the class' armour, items and potion effects
     * 
     * @param player
     *            - The player to apply the class to
     */
    public void applyClass(Player player) {
        PlayerInventory pE = player.getInventory();

        pE.clear();
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }

        if (helmet != null) {
            pE.setHelmet(helmet);
        }
        if (chest != null) {
            pE.setChestplate(chest);
        }
        if (legs != null) {
            pE.setLeggings(legs);
        }
        if (boots != null) {
            pE.setBoots(boots);
        }

        for (int slot : items.keySet()) {
            if (items.get(slot) == null) {
                continue;
            }
            pE.setItem(slot, items.get(slot));
        }

        for (PotionEffect effect : potionEffects) {
            if (effect == null) {
                continue;
            }
            player.addPotionEffect(effect);
        }
    }

    /**
     * Add a potion effect to the class
     * 
     * @param effect
     *            - The potion effect to add
     */
    public void addPotionEffect(PotionEffect effect) {
        potionEffects.add(effect);
    }

    /**
     * Add an item to the class
     * 
     * @param slot
     *            - The slot where the {@link ItemStack} should be spawned
     * @param item
     *            - The {@link ItemStack} to add
     */
    public void addItem(int slot, ItemStack item) {
        if (slot < 9 || slot > 35) {
            return;
        }

        if (items.containsKey(slot)) {
            return;
        }

        items.put(slot, item);
    }

    /**
     * Set an armour piece
     * 
     * @param armourType
     *            - The {@link ArmourType} of the armour piece
     * @param armourPiece
     *            - The {@link ItemStack} the armour piece should be set to
     */
    public void setArmour(ArmourType armourType, ItemStack armourPiece) {
        if (armourType == ArmourType.HELMET) {
            helmet = armourPiece;
        }
        else if (armourType == ArmourType.CHEST) {
            chest = armourPiece;
        }
        else if (armourType == ArmourType.LEGS) {
            legs = armourPiece;
        }
        else if (armourType == ArmourType.BOOTS) {
            boots = armourPiece;
        }
    }

    /**
     * Get the name of the class
     * 
     * @return - the class' name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the class
     * 
     * @return - the class' description
     */
    public String getDescription() {
        return description;
    }
}
