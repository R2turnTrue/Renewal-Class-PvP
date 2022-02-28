package io.github.classpvp.official.listeners.pvp

import io.github.asr.mafp.utils.RED
import io.github.classpvp.official.plugin
import io.github.classpvp.official.utils.lobby
import io.github.classpvp.official.utils.reloadPlayerList
import io.github.classpvp.official.utils.serialKillMap
import net.kyori.adventure.text.Component
import net.kyori.adventure.title.Title
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import java.time.Duration

class PlayerDeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        event.isCancelled = true
        event.player.health = 20.0
        event.player.fireTicks = 0
        event.player.foodLevel = 20
        event.player.showTitle(
            Title.title(
                Component.text("${RED}당신은 죽었습니다!"),
                Component.text(""), Title.Times.of(
                    Duration.ofMillis(250),
                    Duration.ofMillis(2500), Duration.ofMillis(250)
                )
            )
        )

        val player = event.player
        val killer = event.player.killer

        if (killer == null) {
            plugin.server.broadcast(Component.text("${player.name} 님이 사망했습니다!"))
        } else {
            plugin.server.broadcast(Component.text("${player.name} 님이 ${killer.name} 님에게 살해당했습니다!"))
            serialKillMap[killer] = serialKillMap[killer]!! + 1
            killer.reloadPlayerList()
        }

        serialKillMap[player] = 0

        player.reloadPlayerList()
        player.inventory.clear()
        player.lobby()
    }
}