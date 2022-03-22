package io.github.classpvp.official.classes.wizard

import io.github.asr.mafp.utils.WHITE
import io.github.asr.mafp.utils.YELLOW
import io.github.classpvp.official.classes.PvPClass
import io.github.classpvp.official.classes.Rarity
import io.github.classpvp.official.classes.wizard.listener.WizardEvokerFangVictim
import io.github.classpvp.official.classes.wizard.listener.WizardSkill
import io.github.classpvp.official.utils.Lore
import net.kyori.adventure.text.Component
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta

class WizardClass : PvPClass() {
    override fun onRegister() {
        name = Component.text("${YELLOW}마법사")
        lore = Lore(
            listOf(Component.text("${WHITE}마법 클래스")),
            Rarity.BASIC,
            listOf(
                "특정 아이템을 RIGHT CLICK 하여 마법을 사용한다",
                "I. 파이어볼 : 화염구를 날린다 ( COOL TIME : 5 )",
                "II. 프로텍션 : 일시적으로 밀려나지 않고 데미지도 적게 입는다 ( COOL TIME : 30 )",
                "III. 클링 : 범위 내에 있는 플레이어의 발목을 붙잡는다 ( COOL TIME : 30 )"
            )
        )
        icon = ItemStack(Material.ENCHANTED_BOOK)

        chestplate = ItemStack(Material.LEATHER_CHESTPLATE).apply {
            val meta = itemMeta as LeatherArmorMeta
            meta.setColor(Color.BLUE)
        }

        weapons = listOf(
            ItemStack(Material.FIRE_CHARGE),
            ItemStack(Material.CONDUIT),
            ItemStack(Material.LEAD)
        )

        skillListeners = listOf(WizardSkill(), WizardEvokerFangVictim())
    }
}