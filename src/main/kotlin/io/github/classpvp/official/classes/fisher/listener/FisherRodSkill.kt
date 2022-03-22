package io.github.classpvp.official.classes.fisher.listener

import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.pvpClass
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerFishEvent

class FisherRodSkill : Listener {
    @EventHandler
    fun onSkillUse(event: PlayerFishEvent) {
        if (event.player.pvpClass == PlayerClass.FISHER) {
            if (event.caught != null && event.caught is Player) {
                val victim = event.caught!! as Player
                victim.damage(2.0, event.player)
            }
        }
    }
}