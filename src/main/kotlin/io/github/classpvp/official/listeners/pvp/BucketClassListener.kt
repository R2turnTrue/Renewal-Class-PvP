package io.github.classpvp.official.listeners.pvp

import io.github.asr.mafp.utils.Task
import io.github.asr.mafp.utils.runLater
import io.github.classpvp.official.plugin
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBucketEmptyEvent

private fun Material.liquidInBucket(): Material {
    return when (this) {
        Material.WATER_BUCKET -> Material.WATER
        Material.LAVA_BUCKET -> Material.LAVA
        Material.POWDER_SNOW_BUCKET -> Material.POWDER_SNOW
        else -> throw RuntimeException()
    }
}

class BucketClassListener : Listener {
    @EventHandler
    fun onEvent(event: PlayerBucketEmptyEvent) {
        event.isCancelled = true
        if (event.player.hasCooldown(event.bucket)) return
        event.player.setCooldown(event.bucket, 40)
        event.block.type = event.bucket.liquidInBucket()
        plugin.runLater(
            Task {
                 event.block.type = Material.AIR
            }, 3.0
        )
    }
}