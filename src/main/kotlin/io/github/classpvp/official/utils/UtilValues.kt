package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.overWorld
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.plugin
import org.bukkit.Location
import org.bukkit.entity.Player

val playerClassMap = mutableMapOf<Player, PlayerClass?>()

val serialKillMap = mutableMapOf<Player, Int>()

val ableClassListMap = mutableMapOf<Player, MutableSet<PlayerClass>>()

val battleFieldLocations = listOf(
    Location(plugin.overWorld, -0.5, 101.0, -0.5),
    Location(plugin.overWorld, -0.5, 101.0, 20.5),
    Location(plugin.overWorld, 14.5, 101.0, 14.5),
    Location(plugin.overWorld, 20.5, 101.0, -0.5),
    Location(plugin.overWorld, 14.5, 101.0, -15.5),
    Location(plugin.overWorld, -0.5, 101.0, -21.5),
    Location(plugin.overWorld, -15.5, 101.0, -15.5),
    Location(plugin.overWorld, -21.5, 101.0, -0.5),
    Location(plugin.overWorld, -15.5, 101.0, 14.5)
)