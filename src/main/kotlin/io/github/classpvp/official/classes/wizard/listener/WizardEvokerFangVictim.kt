package io.github.classpvp.official.classes.wizard.listener

import io.github.asr.mafp.utils.Task
import io.github.asr.mafp.utils.runLater
import io.github.classpvp.official.plugin
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerMoveEvent

private val wizardSkillVictim = mutableListOf<Player>()

class WizardEvokerFangVictim : Listener {
    @EventHandler
    fun onEvent(event: EntityDamageByEntityEvent) {
        if (event.damager.type == EntityType.EVOKER_FANGS) {
            if (event.entity is Player) {
                event.isCancelled = true
                val victim = event.entity as Player
                victim.damage(5.0)
                wizardSkillVictim.add(victim)
                plugin.runLater(
                    Task {
                        wizardSkillVictim.remove(victim)
                    },
                    7.5
                )
            }
        }
    }

    @EventHandler
    fun onVictimMove(event: PlayerMoveEvent) {
        if (wizardSkillVictim.contains(event.player)) event.isCancelled = true
    }
}