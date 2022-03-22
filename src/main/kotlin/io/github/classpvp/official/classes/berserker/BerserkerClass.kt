package io.github.classpvp.official.classes.berserker

import io.github.asr.mafp.utils.WHITE
import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.utils.Lore
import io.github.classpvp.official.utils.potionEffect
import io.github.classpvp.official.utils.setUnbreakable
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffectType

class BerserkerClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}버서커")
        lore = Lore(
            listOf(Component.text("${WHITE}무거운 클래스")),
            Rarity.RARE,
            potionEffectDescription = "구속, 느린 낙하"
        )
        icon = ItemStack(Material.NETHERITE_AXE)

        chestplate = ItemStack(Material.NETHERITE_CHESTPLATE).apply {
            addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10)
        }.setUnbreakable()

        weapons = listOf(
            ItemStack(Material.NETHERITE_AXE).apply {
                addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5)
            }.setUnbreakable()
        )

        potionEffects = listOf(
            potionEffect(PotionEffectType.SLOW, 3),
            potionEffect(PotionEffectType.SLOW_FALLING, 0)
        )
    }
}