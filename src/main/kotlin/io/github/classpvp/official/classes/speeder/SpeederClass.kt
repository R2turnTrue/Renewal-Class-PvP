package io.github.classpvp.official.classes.speeder

import io.github.asr.mafp.utils.WHITE
import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.utils.Lore
import io.github.classpvp.official.utils.potionEffect
import io.github.classpvp.official.utils.setUnbreakable
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class SpeederClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}스피더")
        lore = Lore(listOf(Component.text("${WHITE}날렵한 클래스")), potionEffectDescription = "신속, 힘")
        icon = ItemStack(Material.GOLDEN_BOOTS)

        boots = ItemStack(Material.GOLDEN_BOOTS).setUnbreakable()

        potionEffects = listOf(
            potionEffect(PotionEffectType.SPEED, 0),
            potionEffect(PotionEffectType.INCREASE_DAMAGE, 1)
        )
    }
}