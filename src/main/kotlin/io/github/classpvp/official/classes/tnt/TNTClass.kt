package io.github.classpvp.official.classes.tnt

import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.classes.tnt.listener.TNTAttack
import io.github.classpvp.official.classes.tnt.listener.TNTSkill
import io.github.classpvp.official.utils.Lore
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TNTClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}TNT")
        lore = Lore(
            listOf(Component.text("최초의 폭격 클래스")),
            Rarity.LEGENDARY,
            listOf(
                "TNT 로 ATTACK 를 하면 폭발 공격을 할 수 있습니다 ( COOL TIME : 5 )",
                "TNT 를 RIGHT CLICK 해 전방위 TNT 를 폭격할 수 있습니다 ( COOL TIME : 20 )"
            )
        )
        icon = ItemStack(Material.TNT)

        weapons = listOf(ItemStack(Material.TNT))

        skillListeners = listOf(TNTSkill(), TNTAttack())
    }
}