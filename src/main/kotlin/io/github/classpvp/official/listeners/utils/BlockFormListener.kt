package io.github.classpvp.official.listeners.utils

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockFormEvent

class BlockFormListener : Listener {
    @EventHandler
    fun onEvent(event: BlockFormEvent) {
        event.isCancelled = true
    }
}