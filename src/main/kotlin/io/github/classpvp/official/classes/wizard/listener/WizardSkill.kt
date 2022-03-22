package io.github.classpvp.official.classes.wizard.listener

import io.github.asr.mafp.entity.forward
import io.github.asr.mafp.utils.spawnEntity
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.pvpClass
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Fireball
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class WizardSkill : Listener {
    @EventHandler
    fun onEvent(event: PlayerInteractEvent) {
        if (event.player.pvpClass == PlayerClass.WIZARD && event.action.isRightClick) {
            event.isCancelled = true
            if (event.player.hasCooldown(event.player.inventory.itemInMainHand.type)) return
            when (event.player.inventory.itemInMainHand.type) {
                Material.FIRE_CHARGE -> {
                    event.player.setCooldown(Material.FIRE_CHARGE, 100)
                    val fireball = event.player.forward(1.0).spawnEntity(EntityType.FIREBALL) as Fireball
                    fireball.isInvulnerable = true
                }

                Material.CONDUIT -> {
                    event.player.setCooldown(Material.CONDUIT, 600)
                    event.player.addPotionEffect(
                        PotionEffect(
                            PotionEffectType.DAMAGE_RESISTANCE, 200, 2, false, false, false
                        )
                    )
                }

                Material.LEAD -> {
                    event.player.setCooldown(Material.LEAD, 600)
                    event.player.location.getNearbyPlayers(7.5).forEach {
                        if (it != event.player) it.location.spawnEntity(EntityType.EVOKER_FANGS)
                    }
                }

                else -> return
            }
        }
    }
}