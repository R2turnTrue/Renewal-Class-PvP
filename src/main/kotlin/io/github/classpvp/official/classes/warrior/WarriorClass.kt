package io.github.classpvp.official.classes.warrior

import io.github.asr.mafp.utils.*
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.utils.Lore
import io.github.classpvp.official.utils.setUnbreakable
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WarriorClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}워리어")
        lore = Lore(listOf(Component.text("${WHITE}가장 기본적인 형태의 클래스")), Rarity.BASIC)
        icon = ItemStack(Material.STONE_SWORD)

        chestplate = ItemStack(Material.IRON_CHESTPLATE).setUnbreakable()
        leggings = ItemStack(Material.IRON_LEGGINGS).setUnbreakable()
        boots = ItemStack(Material.IRON_BOOTS).setUnbreakable()

        weapons = listOf(ItemStack(Material.STONE_SWORD).setUnbreakable())
    }
}