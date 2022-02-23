package io.github.classpvp.official.classes

import io.github.classpvp.official.classes.archer.ArcherClass
import io.github.classpvp.official.classes.warrior.WarriorClass
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
        inventory.helmet = pvpClass.helmet
        inventory.chestplate = pvpClass.helmet
        inventory.leggings = pvpClass.helmet
        inventory.boots = pvpClass.boots

        pvpClass.weapons.orEmpty().forEach {
            inventory.addItem(it)
        }

        addPotionEffects(pvpClass.potionEffects.orEmpty())
    }
}

enum class PlayerClass(val number: Int, val pvpClass: PvPClass) {
    WARRIOR(0, WarriorClass()),
    ARCHER(1, ArcherClass());

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