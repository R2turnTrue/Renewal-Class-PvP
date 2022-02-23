package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.*
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

private fun thisGameKill(kill: Int) = "This Game's Kill : $kill"

fun Player.registerPlayerList() {
    this.sendPlayerListHeader(Component.text("${YELLOW}Class$RED PvP$AQUA Official Server"))
    serialKillMap[this] = 0
    reloadPlayerList()
}

fun Player.reloadPlayerList() {
    this.sendPlayerListFooter(Component.text(thisGameKill(serialKillMap[this]!!)))
}