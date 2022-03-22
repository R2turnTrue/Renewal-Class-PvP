package io.github.classpvp.official.classes.assassin.listener

import io.github.asr.mafp.utils.RED
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.classes.pvpClass
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class AssassinHidingSkill : Listener {
    @EventHandler
    fun onSkillUse(event: PlayerToggleSneakEvent) {
        if (event.player.pvpClass == PlayerClass.ASSASSIN) {
            if (event.player.hasCooldown(Material.BARRIER)) {
                event.player.sendActionBar(
                    Component.text(
                        "${RED}${event.player.getCooldown(Material.BARRIER).toDouble() / 20} 초 남았습니다!"
                    )
                )
                return
            }
            event.player.arrowsStuck = 0
            event.player.setCooldown(Material.BARRIER, 600)
            event.player.addPotionEffect(
                PotionEffect(
                    PotionEffectType.INVISIBILITY, 400, 0, false, false, false
                )
            )
        }
    }
}