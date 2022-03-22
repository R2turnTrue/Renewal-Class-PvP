package io.github.classpvp.official.classes.hot

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
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class HotClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}핫")
        lore = Lore(listOf(
            Component.text("${WHITE}테러형 클래스")),
            Rarity.UNCOMMON,
            potionEffectDescription = "화염 저항"
        )
        icon = ItemStack(Material.LAVA_BUCKET)

        weapons = listOf(
            ItemStack(Material.STONE_PICKAXE).apply {
                addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10)
            }.setUnbreakable(),
            ItemStack(Material.LAVA_BUCKET)
        )

        potionEffects = listOf(
            potionEffect(PotionEffectType.FIRE_RESISTANCE, 0)
        )
    }
}