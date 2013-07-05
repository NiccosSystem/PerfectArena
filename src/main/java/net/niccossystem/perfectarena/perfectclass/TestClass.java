package net.niccossystem.perfectarena.perfectclass;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class TestClass extends PerfectClass {

    public TestClass() {
        super("A test class", "Worst class in the world");
        generateArmour();
        generateItems();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void generateArmour() {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        setArmour(ArmourType.HELMET, helmet);
        
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        setArmour(ArmourType.CHEST, chestplate);
        
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        setArmour(ArmourType.LEGS, leggings);        
        
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        setArmour(ArmourType.BOOTS, boots);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void generateItems() {
        ItemStack sword = new ItemStack(Material.WOOD_SWORD);
        addItem(0, sword);
        
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 5);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        addItem(1, bow);
        
        ItemStack arrow = new ItemStack(Material.ARROW);
        addItem(2, arrow);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void generatePotionEffects() {
        PotionEffect effect1 = new PotionEffect(PotionEffectType.SLOW, 5000, 1);
        addPotionEffect(effect1);        
    }
    
    

}
