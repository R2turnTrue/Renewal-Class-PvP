package io.github.classpvp.official.classes

import io.github.asr.mafp.server.registerListeners
import io.github.classpvp.official.classes.archer.ArcherClass
import io.github.classpvp.official.classes.assassin.AssassinClass
import io.github.classpvp.official.classes.berserker.BerserkerClass
import io.github.classpvp.official.classes.fisher.FisherClass
import io.github.classpvp.official.classes.hot.HotClass
import io.github.classpvp.official.classes.speeder.SpeederClass
import io.github.classpvp.official.classes.tnt.TNTClass
import io.github.classpvp.official.classes.warrior.WarriorClass
import io.github.classpvp.official.classes.wizard.WizardClass
import io.github.classpvp.official.plugin
import io.github.classpvp.official.utils.playerClassMap
import org.bukkit.entity.Player
import java.lang.RuntimeException

var Player.pvpClass: PlayerClass?
    get() = playerClassMap[this]
    set(value) {
        playerClassMap[this] = value
    }

fun Player.equip() {
    if (pvpClass != null) {
        val pvpClass = pvpClass!!.pvpClass
        pvpClass.onRegister()
        inventory.helmet = pvpClass.helmet
        inventory.chestplate = pvpClass.chestplate
        inventory.leggings = pvpClass.leggings
        inventory.boots = pvpClass.boots

        pvpClass.weapons.orEmpty().forEach {
            inventory.addItem(it)
        }

        addPotionEffects(pvpClass.potionEffects)

        pvpClass.skillListeners.forEach {
            plugin.registerListeners(it)
        }
    }
}

enum class PlayerClass(val number: Int, val pvpClass: PvPClass) {
    WARRIOR(0, WarriorClass()),
    ARCHER(1, ArcherClass()),
    SPEEDER(2, SpeederClass()),
    WIZARD(3, WizardClass()),
    HOT(4, HotClass()),
    ASSASSIN(5, AssassinClass()),
    FISHER(6, FisherClass()),
    BERSERKER(7, BerserkerClass()),
    TNT(8, TNTClass());

    companion object {
        @JvmStatic
        fun maxIndex(): Int = values().size

        @JvmStatic
        fun pvpClass(number: Int): PlayerClass {
            values().forEach {
                if (it.number == number) return it
            }

            throw RuntimeException()
        }
    }
}