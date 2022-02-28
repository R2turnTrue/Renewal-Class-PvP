package io.github.classpvp.official.listeners.utils

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class BlockBreakListener : Listener {
    @EventHandler
    fun onEvent(event: BlockBreakEvent) {
        event.isCancelled = !event.player.isOp
    }
}