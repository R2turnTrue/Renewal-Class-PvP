package io.github.classpvp.official.classes.tnt.listener

import io.github.asr.mafp.utils.spawnEntity
import io.github.asr.mafp.utils.spawnParticle
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.pvpClass
import io.github.classpvp.official.plugin
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ExplosionPrimeEvent
import org.bukkit.event.player.PlayerInteractEvent
import kotlin.math.sqrt

class TNTSkill : Listener {
    @EventHandler
    fun onEvent(event: PlayerInteractEvent) {
        if (event.action.isRightClick && event.player.pvpClass == PlayerClass.TNT && !event.player.hasCooldown(Material.TNT)) {
            event.player.location.spawnEntity(EntityType.PRIMED_TNT)
            event.player.setCooldown(Material.TNT, 400)
        }
    }

    @EventHandler
    fun onExplosion(event: ExplosionPrimeEvent) {
        if (event.entityType == EntityType.PRIMED_TNT) {
            event.isCancelled = true
            event.entity.location.spawnParticle(Particle.EXPLOSION_HUGE, 1)
            plugin.server.onlinePlayers.forEach {
                if (it.pvpClass != null) {
                    val damage = 40 / sqrt(event.entity.location.distance(it.location))
                    if (it.pvpClass == PlayerClass.TNT) it.damage(damage / 6)
                    else it.damage(damage)
                }
            }
        }
    }
}