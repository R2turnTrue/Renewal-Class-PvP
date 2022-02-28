package io.github.classpvp.official.listeners.utils

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerAttemptPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent

class DroppedItemListener : Listener {
    @EventHandler
    fun onDropEvent(event: PlayerDropItemEvent) {
        event.isCancelled = true
    }

    @EventHandler
    fun onPickUpEvent(event: PlayerAttemptPickupItemEvent) {
        event.isCancelled = true
    }
}