package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.GREEN
import io.github.classpvp.official.classes.PlayerClass
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

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