package net.niccossystem.perfectarena.serialize;

import java.util.List;
import net.niccossystem.perfectarena.perfectclass.ArmourType;
import net.niccossystem.perfectarena.perfectclass.PerfectClass;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PerfectClassSerializer {

    public static PerfectClass deserialize(String name, List<String> serialized) {
        PerfectClass pClass = new PerfectClass(name);

        String description = "";

        for (String attribute : serialized) {
            if (attribute.startsWith("Description: ")) {
                description += attribute.replaceFirst("Description: ", "");
            }
            else if (attribute.startsWith("Potion: ")) {
                String[] serializedPotion = attribute.replaceFirst("Potion: ", "").split(":");
                PotionEffectType pet = PotionEffectType.getByName(serializedPotion[0]);
                PotionEffect effect = new PotionEffect(pet, Integer.parseInt(serializedPotion[1]), Integer.parseInt(serializedPotion[2]));
                pClass.addPotionEffect(effect);
            }
            else if (attribute.startsWith("Helmet: ")) {
                String serializedHelmet = attribute.replaceFirst("Helmet: ", "");
                pClass.setArmour(ArmourType.HELMET, PerfectClassSerializer.deserializeArmour(serializedHelmet));
            }
            else if (attribute.startsWith("Chest: ")) {
                String serializedHelmet = attribute.replaceFirst("Chest: ", "");
                pClass.setArmour(ArmourType.CHEST, PerfectClassSerializer.deserializeArmour(serializedHelmet));
            }
            else if (attribute.startsWith("Legs: ")) {
                String serializedHelmet = attribute.replaceFirst("Legs: ", "");
                pClass.setArmour(ArmourType.LEGS, PerfectClassSerializer.deserializeArmour(serializedHelmet));
            }
            else if (attribute.startsWith("Boots: ")) {
                String serializedHelmet = attribute.replaceFirst("Boots: ", "");
                pClass.setArmour(ArmourType.BOOTS, PerfectClassSerializer.deserializeArmour(serializedHelmet));
            }
            else if (attribute.startsWith("Item: ")) {
                String serializedItem = attribute.replaceFirst("Item: ", "");
                ItemStack item = PerfectClassSerializer.deserializeItem(serializedItem);
                int slot = Integer.parseInt(serializedItem.split(",")[0]);
                pClass.addItem(slot, item);
            }
        }
        pClass.setDescription(description);
        return pClass;
    }

    private static ItemStack deserializeArmour(String serializedArmour) {
        String[] item = null;
        String[] enchantments = new String[1];
        if (serializedArmour.contains("#")) {
            item = serializedArmour.split("#")[0].split(",");
            String combinedEnchants = serializedArmour.split("#")[1];
            if (combinedEnchants.contains(",")) {
                enchantments = combinedEnchants.split(",");
            }
            else {
                enchantments[0] = combinedEnchants;
            }
        }
        if (item == null) {
            item = serializedArmour.split(",");
        }
        ItemStack armourPiece = new ItemStack(Integer.parseInt(item[0]), 1, Short.parseShort(item[1]));

        for (String enchantment : enchantments) {
            Enchantment enc = Enchantment.getByName(enchantment.split(":")[0]);
            if (enc != null) {
                int level = Integer.parseInt(enchantment.split(":")[1]);
                armourPiece.addEnchantment(enc, level);
            }
        }
        return armourPiece;
    }

    private static ItemStack deserializeItem(String serializedItem) {
        String[] item = null;
        String[] enchantments = new String[1];
        if (serializedItem.contains("#")) {
            item = serializedItem.split("#")[0].split(",");
            String combinedEnchants = serializedItem.split("#")[1];
            if (combinedEnchants.contains(",")) {
                enchantments = combinedEnchants.split(",");
            }
            else {
                enchantments[0] = combinedEnchants;
            }
        }
        if (item == null) {
            item = serializedItem.split(",");
        }
        ItemStack realItem = new ItemStack(Integer.parseInt(item[1]), Integer.parseInt(item[2]), Short.parseShort(item[3]));

        for (String enchantment : enchantments) {
            Enchantment enc = Enchantment.getByName(enchantment.split(":")[0]);
            if (enc != null) {
                int level = Integer.parseInt(enchantment.split(":")[1]);
                realItem.addEnchantment(enc, level);
            }
        }
        return realItem;
    }
}
