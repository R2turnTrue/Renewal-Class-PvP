package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.AQUA
import io.github.asr.mafp.utils.GREEN
import io.github.asr.mafp.utils.overWorld
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.equip
import io.github.classpvp.official.plugin
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

fun ItemStack.setUnbreakable() = this.apply {
    editMeta {
        it.isUnbreakable = true
    }
}

fun Player.grantClass(pvpClass: PlayerClass) {
    ableClassListMap[this]!!.add(pvpClass)
    server.broadcast(Component.text("$name 님이$GREEN ${pvpClass.name} 클래스를 해금했습니다!"))
}

fun Player.revokeClass(pvpClass: PlayerClass) {
    ableClassListMap[this]!!.remove(pvpClass)
    server.broadcast(Component.text("$name 님이$GREEN ${pvpClass.name} 클래스를 봉인당했습니다!"))
}

fun Player.lobby() {
    teleport(Location(plugin.overWorld, 0.0, 64.0, 0.0))
    inventory.setItem(8, ItemStack(Material.CLOCK).apply {
        editMeta {
            it.displayName(Component.text("${AQUA}클래스 선택기"))
        }
    })
}

fun Player.battleField() {
    teleport(battleFieldLocations.random())
    inventory.clear()
    equip()
}

fun potionEffect(
    potionEffectType: PotionEffectType,
    amplifier: Int,
    ambient: Boolean = false,
    particles: Boolean = false,
    icon: Boolean = false
) = PotionEffect(potionEffectType, Int.MAX_VALUE, amplifier, ambient, particles, icon)