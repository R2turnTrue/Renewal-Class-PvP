package io.github.classpvp.official.listeners.utils

import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.utils.ableClassListMap
import io.github.classpvp.official.utils.lobby
import io.github.classpvp.official.utils.registerPlayerList
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.registerPlayerList()
        ableClassListMap[event.player] = mutableSetOf(PlayerClass.WARRIOR)

        event.player.lobby()
    }
}