package io.github.classpvp.official.classes.assassin

import io.github.asr.mafp.utils.WHITE
import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.classes.assassin.listener.AssassinHidingSkill
import io.github.classpvp.official.utils.Lore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class AssassinClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}어쎄신")
        lore = Lore(
            listOf(Component.text("${WHITE}은신 클래스")),
            Rarity.UNCOMMON,
            listOf("SNEAK 를 해 20 초 동안 은신 ( COOL TIME : 40 )")
        )
        icon = ItemStack(Material.BARRIER)

        weapons = listOf(
            ItemStack(Material.IRON_SWORD).apply {
                addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1)
            }
        )
        skillListeners = listOf(AssassinHidingSkill())
    }
}