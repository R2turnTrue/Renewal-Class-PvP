package io.github.classpvp.official.classes.archer

import io.github.asr.mafp.utils.*
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.utils.Lore
import io.github.classpvp.official.utils.setUnbreakable
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class ArcherClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}궁수")
        lore = Lore(listOf(Component.text("${WHITE}궁수 클래스")), Rarity.BASIC)
        icon = ItemStack(Material.BOW)

        helmet = ItemStack(Material.CHAINMAIL_HELMET).apply {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
        }.setUnbreakable()
        chestplate = ItemStack(Material.CHAINMAIL_CHESTPLATE).apply {
            addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
        }.setUnbreakable()

        weapons = listOf(ItemStack(Material.BOW).apply {
            addEnchantment(Enchantment.ARROW_INFINITE, 1)
        }.setUnbreakable(), ItemStack(Material.ARROW))
    }
}