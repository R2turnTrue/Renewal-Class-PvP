package io.github.classpvp.official.classes.fisher

import io.github.asr.mafp.utils.WHITE
import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.classes.fisher.listener.FisherRodSkill
import io.github.classpvp.official.utils.Lore
import io.github.classpvp.official.utils.potionEffect
import io.github.classpvp.official.utils.setUnbreakable
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffectType

class FisherClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}낚시꾼")
        lore = Lore(
            listOf(Component.text("${WHITE}친수성 클래스")),
            Rarity.RARE,
            potionEffectDescription = "돌고래의 가호"
        )
        icon = ItemStack(Material.FISHING_ROD)

        weapons = listOf(
            ItemStack(Material.FISHING_ROD).setUnbreakable()
        )

        potionEffects = listOf(
            potionEffect(PotionEffectType.DOLPHINS_GRACE, 2)
        )

        skillListeners = listOf(FisherRodSkill())
    }
}